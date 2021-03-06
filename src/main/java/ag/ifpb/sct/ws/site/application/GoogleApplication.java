package ag.ifpb.sct.ws.site.application;

import org.restlet.Context;
import org.restlet.routing.Router;

import ag.ifpb.sct.ws.site.resource.html.GooglePageResource;


public class GoogleApplication extends AbstractApplication{
  
  @Override
  protected Router createRouter(Context ctx) {
    Router routing = new Router(ctx);
    routing.attachDefault(GooglePageResource.class);
    return routing;
  }

}
