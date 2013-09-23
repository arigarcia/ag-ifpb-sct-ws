package ag.ifpb.sct.ws.site.application;

import org.restlet.Context;
import org.restlet.routing.Redirector;


public class RedirectorFactory {
  private final Context context;

  private Redirector createRedirector(String targetPattern) {
    return new Redirector(context, targetPattern,
        Redirector.MODE_CLIENT_TEMPORARY);
  }

  public RedirectorFactory(Context context) {
    this.context = context;
  }

  public static final String UNLOGGED = "unlogged";
  public static final String DEFAULT = "default";
  public static final String ERROR = "error";
  
  public Redirector create(String kind) {
    return create(kind, null);
  }
  
  public Redirector create(String kind, String queryString) {
    //
    String params = (queryString != null ? "?" + queryString : "");
    //
    if (DEFAULT.equals(kind)) {
      return createRedirector("/site/home"  + params);
    } 
    else if (UNLOGGED.equals(kind)) {
      return createRedirector("/error/unlogged" + params);
    }
    else {
      return createRedirector("/error/default" + params);
    }
  }

}
