/*
 * generated by Xtext
 */
package org.xtext.activitydiagram.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class ActivityDiagramAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("org/xtext/activitydiagram/parser/antlr/internal/InternalActivityDiagram.tokens");
	}
}