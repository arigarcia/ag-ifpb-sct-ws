package ag.ifpb.sct.ws.site;

import java.util.logging.Level;
import java.util.logging.Logger;


public class App {

  public static void main(String[] args) {
    String port = System.getenv("PORT");
    if (port == null || port.isEmpty()) {
      port = "8080";
    }
    //
    WebComponent webcomponent = new WebComponent(Integer.parseInt(port));
    Logger logger = webcomponent.getLogger();
    logger.setLevel(Level.WARNING);
    try {
      webcomponent.start();
      logger.info("Web component started.");
    }
    catch (Exception e) {
      logger.log(Level.SEVERE, "Web component no started.", e);
    }
  }

}
