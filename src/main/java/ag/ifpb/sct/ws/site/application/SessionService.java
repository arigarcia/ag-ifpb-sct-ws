package ag.ifpb.sct.ws.site.application;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Cookie;
import org.restlet.data.CookieSetting;
import org.restlet.util.Series;


public class SessionService {
  public static final String AGSESSIONID = "AGSESSIONID";
  
  public static void create(Response response, String sessionId, int age){
    // create cookies
    CookieSetting cs = new CookieSetting(AGSESSIONID, sessionId);
    cs.setMaxAge(age);
    cs.setPath("/");
    // store cookies
    response.getCookieSettings().add(cs);
  }
  
  public static void create(Response response, String sessionId){
    create(response, sessionId, 3600*24*8);
  }
  
  public static String getId(Request request){
    String id = null;
    Series<Cookie> cookies = request.getCookies();
    for (Cookie cookie : cookies) {
      String n = cookie.getName();
      if (AGSESSIONID.equals(n)) {
        id = cookie.getValue();
        break;
      }
    }
    return id;
  }
  
  public static void invalidate(Response response){
    create(response, "invalid", 0);
  }

}
