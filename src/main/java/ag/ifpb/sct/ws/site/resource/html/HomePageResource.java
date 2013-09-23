package ag.ifpb.sct.ws.site.resource.html;

import org.restlet.representation.Representation;


public class HomePageResource extends AbstractPageResource {

  @Override
  protected Representation process(Representation rep) {
    return TemplateConfiguration.createTemplateByIndex(getRequest(), "home", null);
  }

}
