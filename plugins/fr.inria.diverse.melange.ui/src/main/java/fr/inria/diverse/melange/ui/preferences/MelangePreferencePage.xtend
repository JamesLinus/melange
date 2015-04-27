package fr.inria.diverse.melange.ui.preferences

import fr.inria.diverse.melange.ui.internal.MelangeActivator
import fr.inria.diverse.melange.utils.MelangePreferencesConstants
import org.eclipse.jface.preference.BooleanFieldEditor
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Group
import org.eclipse.ui.IWorkbench
import org.eclipse.xtext.ui.editor.preferences.LanguageRootPreferencePage

class MelangePreferencePage extends LanguageRootPreferencePage
{
	override init(IWorkbench workbench) {
		setPreferenceStore(MelangeActivator.instance.preferenceStore)
	}

	override createFieldEditors() {
		val parent = fieldEditorParent
		val group = new Group(parent, SWT.SHADOW_IN) => [
			text = "Generation"
			layoutData = new GridData(SWT.FILL, SWT.TOP, true, false)
			layout = new GridLayout(1, false)
		]

		val composite = new Composite(group, SWT.NONE)

		addField(
			new BooleanFieldEditor(
				MelangePreferencesConstants.EMF_COMPLIANT_INTERFACES,
				"Generate EMF-compliant interfaces",
				composite
			)
		)

		addField(
			new BooleanFieldEditor(
				MelangePreferencesConstants.GENERATE_EMF_ARTIFACTS,
				"Automatically generate EMF runtime for newly generated artifacts",
				composite
			)
		)

		group.pack
	}
}
