package ag.ifpb.sct.ws.site.resource.file;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.zip.GZIPOutputStream;

import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Encoding;
import org.restlet.data.Reference;
import org.restlet.representation.FileRepresentation;
import org.restlet.representation.InputRepresentation;
import org.restlet.resource.Directory;


public abstract class AbstractDirectory extends Directory {
  
  public AbstractDirectory(Context context, Reference rootLocalReference) {
    super(context, rootLocalReference);
  }

  @Override
  public void handle(Request request, Response response) {
    super.handle(request, response);
    //
    if (response.isEntityAvailable()){
      FileRepresentation fr =  (FileRepresentation) response.getEntity();
      try {
        InputStream infr = fr.getStream();
        //read bytes in 
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] byteloader = new byte[1];
        while(infr.read(byteloader) > -1){
          baos.write(byteloader);
        }
        byte[] byteresult = baos.toByteArray();
        baos.flush();
        baos.close();
        //compress bytes
        ByteArrayOutputStream gzipbaos = new ByteArrayOutputStream();
        GZIPOutputStream gzipout = new GZIPOutputStream(gzipbaos);
        gzipout.write(byteresult);
        gzipout.finish();
        gzipout.close();
        //convert to inputstream
        ByteArrayInputStream gzipfile = new ByteArrayInputStream(gzipbaos.toByteArray());
        gzipbaos.flush();
        gzipbaos.close();
        //new expirations
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fr.getExpirationDate());
        calendar.add(Calendar.WEEK_OF_MONTH, 1);
        //result
        InputRepresentation result = new InputRepresentation(gzipfile, fr.getMediaType());
        result.getEncodings().add(Encoding.GZIP);
        result.setDisposition(fr.getDisposition());
        result.setExpirationDate(calendar.getTime());
        result.setLanguages(fr.getLanguages());
        result.setLocationRef(fr.getLocationRef());
        result.setModificationDate(fr.getModificationDate());
        result.setSize(gzipfile.available());
        result.setCharacterSet(fr.getCharacterSet());
        //set gzipped response
        response.setEntity(result);
      } 
      catch (IOException e) {
        getLogger().log(Level.SEVERE, "Directory routing error.", e);
      }
    }
  }
  
}
