package fr.inria.diverse.melange.processors

import com.google.inject.Inject
import fr.inria.diverse.melange.metamodel.melange.MelangeFactory
import fr.inria.diverse.melange.metamodel.melange.Weave
import java.util.List
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.jdt.core.IPackageFragment
import org.eclipse.jdt.core.search.IJavaSearchConstants
import org.eclipse.jdt.core.search.SearchEngine
import org.eclipse.jdt.core.search.SearchMatch
import org.eclipse.jdt.core.search.SearchPattern
import org.eclipse.jdt.core.search.SearchRequestor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeReferenceBuilder

class WildcardAspectResolver extends DispatchMelangeProcessor
{
	@Inject JvmTypeReferenceBuilder.Factory builderFactory

	def dispatch void preProcess(Weave w, boolean preLinkingPhase) {
		val typeRefBuilder = builderFactory.create(w.eResource.resourceSet)
		if (w.aspectWildcardImport !== null) {
			resolveWildcardImport(w.aspectWildcardImport).forEach[typeRef |
				w.owningLanguage.operators += MelangeFactory.eINSTANCE.createWeave => [
					aspectTypeRef = typeRefBuilder.typeRef(typeRef)
				]
			]
		}
	}

	private def List<String> resolveWildcardImport(String wildcardImport) {
		val matches = newArrayList
		val engine = new SearchEngine

		val requestor = new SearchRequestor() {
			override acceptSearchMatch(SearchMatch match) {
				if (match.element instanceof IPackageFragment) {
					val pkg = match.element as IPackageFragment

					pkg.children.forEach[child |
						val name = child.elementName

						// No Context/Properties classes generated from  @Aspect
						if (!(
							   (name.endsWith("Context.java")
							&& name.substring(0, (name.length - 12) / 2) == name.substring((name.length - 12) / 2, name.length - 12))
							|| (name.endsWith("Properties.java")
							&& name.substring(0, (name.length - 15) / 2) == name.substring((name.length - 15) / 2, name.length - 15))	
						))
							matches.add(pkg.elementName + "." + name.substring(0, name.length - 5))
						]
				}
			}
		}

		val pattern = SearchPattern.createPattern(
			wildcardImport.substring(0, wildcardImport.length - 2),
			IJavaSearchConstants.PACKAGE,
			IJavaSearchConstants.DECLARATIONS,
			SearchPattern.R_EXACT_MATCH//.bitwiseOr(SearchPattern.R_CASE_SENSITIVE)
		)

		engine.search(
			pattern,
			#[SearchEngine.defaultSearchParticipant],
			SearchEngine.createWorkspaceScope,
			requestor,
			null
		)

		return matches
	}
}
