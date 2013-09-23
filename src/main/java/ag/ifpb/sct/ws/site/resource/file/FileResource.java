package ag.ifpb.sct.ws.site.resource.file;

import java.net.URL;

import org.restlet.Context;
import org.restlet.data.Reference;


public class FileResource extends AbstractDirectory {

  public FileResource(Context context, URL csspath) {
    super(context, new Reference(csspath));
  }

  

}
