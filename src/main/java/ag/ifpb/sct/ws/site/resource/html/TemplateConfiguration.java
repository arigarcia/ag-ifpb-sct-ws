package ag.ifpb.sct.ws.site.resource.html;

import java.net.URL;

import org.restlet.Context;
import org.restlet.Request;
import org.restlet.data.MediaType;
import org.restlet.data.Reference;
import org.restlet.ext.freemarker.ContextTemplateLoader;
import org.restlet.ext.freemarker.TemplateRepresentation;

import freemarker.template.Configuration;


public class TemplateConfiguration {
	private static Boolean _block = true;
	private static Configuration configuration;
	
	public static TemplateRepresentation createTemplateByIndex(Request request, String page, Object data){
		//process
		String url = request.getRootRef().toString();
		//data
		DataResult result = new DataResult(url, page);
		result.setData(data);
		//template
		TemplateRepresentation tr = new TemplateRepresentation(
				"index.htpl", configuration, result, MediaType.TEXT_HTML
		);
		//result
		return tr;
	}
	
	public static TemplateRepresentation createTemplateByNone(Request request, String page, Object data){
      //process
      String url = request.getRootRef().toString();
      //data
      DataResult result = new DataResult(url, page);
      result.setData(data);
      //template
      TemplateRepresentation tr = new TemplateRepresentation(
              "none.htpl", configuration, result, MediaType.TEXT_HTML
      );
      //result
      return tr;
  }
	
	public static TemplateRepresentation createTemplate(Request request, String page){
		return createTemplateByIndex(request, page, null);
	}
	
	public static void initConfiguration(Context context, URL tplpath) {
		if (configuration == null) {
			synchronized (_block) {
				if (configuration == null) {
					configuration = new Configuration();
					configuration.clearEncodingMap();
					configuration.setDefaultEncoding("UTF-8");
					configuration.setOutputEncoding("UTF-8");
					configuration.setTemplateLoader(new ContextTemplateLoader(
							context, new Reference(tplpath)
					));
				}
			}
		}
	}

}
