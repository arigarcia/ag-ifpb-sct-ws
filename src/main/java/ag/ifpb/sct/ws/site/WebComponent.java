package ag.ifpb.sct.ws.site;

import org.restlet.Component;
import org.restlet.data.Protocol;
import org.restlet.routing.Template;
import org.restlet.routing.VirtualHost;

import ag.ifpb.sct.ws.site.application.ErrorApplication;
import ag.ifpb.sct.ws.site.application.GoogleApplication;
import ag.ifpb.sct.ws.site.application.RedirectApplication;
import ag.ifpb.sct.ws.site.application.SiteApplication;
import ag.ifpb.sct.ws.site.application.WebServiceApplication;


public class WebComponent extends Component {

  public WebComponent(int port) {
    // clients
    getClients().add(Protocol.JAR);
    getClients().add(Protocol.FILE);
    // server
    getServers().add(Protocol.HTTP, port);
    // adicionar o roteamento da aplicação
    VirtualHost host = getDefaultHost();
    // for google
    host.attach("/", new RedirectApplication());
    // for site
    host.attach("/site", new SiteApplication());
    // for site
    host.attach("/ws", new WebServiceApplication());
    // for google
    host.attach("/googlebcdaf70bc23419db.html", new GoogleApplication(), Template.MODE_EQUALS);
    // for site
    host.attach("/error", new ErrorApplication());
  }

}

