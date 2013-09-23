package ag.ifpb.sct.ws.site.application;

import java.net.URL;

import org.restlet.Context;
import org.restlet.routing.Router;

import ag.ifpb.sct.ws.site.resource.html.TemplateConfiguration;
import ag.ifpb.sct.ws.site.resource.file.FileResource;


public class DirectoryRouter extends Router {

  public DirectoryRouter(Context context) {
    // context
    super(context);
    // site resource path
    URL imgpath = getClass().getResource("/webapp/img");
    URL csspath = getClass().getResource("/webapp/css");
    URL jspath = getClass().getResource("/webapp/js");
    URL tplpath = getClass().getResource("/webapp/tpl");
    URL ejspath = getClass().getResource("/webapp/ejs");
    URL fontspath = getClass().getResource("/webapp/fonts");
    // configure template
    TemplateConfiguration.initConfiguration(getContext(), tplpath);
    // site resource
    attach("/img", new FileResource(getContext(), imgpath));
    attach("/css", new FileResource(getContext(), csspath));
    attach("/js", new FileResource(getContext(), jspath));
    attach("/ejs", new FileResource(getContext(), ejspath));
    attach("/fonts", new FileResource(getContext(), fontspath));
  }

}
