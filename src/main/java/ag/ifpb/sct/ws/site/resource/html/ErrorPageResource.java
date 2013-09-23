package ag.ifpb.sct.ws.site.resource.html;

import org.restlet.representation.Representation;


public class ErrorPageResource extends AbstractPageResource {

  @Override
  protected Representation process(Representation representation) {
    String msg = "Ops! Esta página não existe. Tente esta <a href='/site/home'>aqui</a>.";
    return TemplateConfiguration.createTemplateByIndex(getRequest(), "error", msg);
  }

}
