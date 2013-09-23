package ag.ifpb.sct.ws.site.application;

import org.restlet.Application;
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.data.CharacterSet;
import org.restlet.data.Encoding;
import org.restlet.data.Language;
import org.restlet.data.MediaType;
import org.restlet.routing.Router;
import org.restlet.service.RangeService;

import ag.ifpb.sct.ws.site.resource.html.ErrorPageResource;

public abstract class AbstractApplication extends Application {
	
	protected abstract Router createRouter(Context ctx);
	
	public AbstractApplication() {
		//disable service (remove header -> accept-range: bytes)
		setRangeService(new RangeService(false));
		//encode
		getMetadataService().setDefaultCharacterSet(CharacterSet.UTF_8);
		getMetadataService().setDefaultEncoding(Encoding.ALL);
		getMetadataService().setDefaultLanguage(Language.ENGLISH_US);
		getMetadataService().setDefaultMediaType(MediaType.TEXT_HTML);
	}
	
	@Override
	public synchronized Restlet createInboundRoot() {
		Router root = new Router(getContext());
		//site resource path
		DirectoryRouter diretory = new DirectoryRouter(getContext());
		root.attach("/assets", diretory);
		//routing pages
		Router routing = createRouter(getContext());
		root.attach(routing);
		//error
		root.attachDefault(ErrorPageResource.class);
		return root;
	}

}
