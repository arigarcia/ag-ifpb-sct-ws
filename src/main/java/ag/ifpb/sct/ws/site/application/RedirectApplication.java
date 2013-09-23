package ag.ifpb.sct.ws.site.application;

import org.restlet.Context;
import org.restlet.routing.Router;


public class RedirectApplication extends AbstractApplication {

  @Override
  protected Router createRouter(Context ctx) {
    Router routing = new Router(ctx);
    RedirectorFactory factory = new RedirectorFactory(getContext());
    routing.attachDefault(factory.create(RedirectorFactory.DEFAULT));
    return routing;
  }

}
