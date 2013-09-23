package ag.ifpb.sct.ws.site.resource.html;

import org.restlet.representation.Representation;
import org.restlet.resource.ResourceException;


public abstract class AbstractPageResource extends AbstractResource {
  
  protected abstract Representation process(Representation representation);
  
  @Override
  protected Representation get() throws ResourceException {
    return process(null);
  }
  
  @Override
  protected Representation post(Representation entity) throws ResourceException {
    return process(entity);
  }
  
}
