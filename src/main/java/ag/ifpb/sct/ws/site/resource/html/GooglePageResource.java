package ag.ifpb.sct.ws.site.resource.html;

import org.restlet.representation.Representation;


public class GooglePageResource extends AbstractPageResource {

  @Override
  protected Representation process(Representation representation) {
    return TemplateConfiguration.createTemplateByNone(getRequest(), "google", null);
  }

}
