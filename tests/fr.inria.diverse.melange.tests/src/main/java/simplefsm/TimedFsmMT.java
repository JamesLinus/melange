package simplefsm;

import fr.inria.diverse.melange.lib.IModelType;
import java.io.IOException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import simplefsm.timedfsmmt.timedfsm.TimedfsmFactory;

@SuppressWarnings("all")
public interface TimedFsmMT extends IModelType {
  public abstract EList<EObject> getContents();
  
  public abstract TimedfsmFactory getFactory();
  
  public abstract void save(final String uri) throws IOException;
}
