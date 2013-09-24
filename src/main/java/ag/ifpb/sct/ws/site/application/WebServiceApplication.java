package ag.ifpb.sct.ws.site.application;

import org.restlet.Context;
import org.restlet.routing.Router;

import ag.ifpb.sct.ws.site.resource.json.ImageResource;


public class WebServiceApplication extends AbstractApplication {

  @Override
  protected Router createRouter(Context ctx) {
    Router routing = new Router(ctx);
    routing.attach("/image", ImageResource.class);
    return routing;
  }

}
