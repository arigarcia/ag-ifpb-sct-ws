package ag.ifpb.sct.ws.site.resource.json;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.restlet.ext.fileupload.RestletFileUpload;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.StreamRepresentation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class ImageResource extends ServerResource {
	
	private String calculateName(byte[] bytefile){
		try{
			MessageDigest digest = MessageDigest.getInstance("MD5");
			byte[] byteresume = digest.digest(bytefile);
			BigInteger integer = new BigInteger(1, byteresume);
			return integer.toString(16);
		}
		catch (NoSuchAlgorithmException e) {
			return String.valueOf(System.currentTimeMillis());
		}
	}

	@Post
	public JsonRepresentation upload(StreamRepresentation representation){
		//
		JSONResult result = new JSONResult();
		//
		try {
			File repository = new File("temp");
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory(5000, repository);
			RestletFileUpload upload = new RestletFileUpload(fileItemFactory);
			List<FileItem> list = upload.parseRepresentation(representation);
			//
			int listsize = list.size();
			for (int i = 0; i < listsize; i++){
				FileItem fi = list.get(i);
				String name = calculateName(fi.get());
				FileOutputStream fileOutputStream = new FileOutputStream("temp/" + name + ".png");
				fileOutputStream.write(fi.get());
				fileOutputStream.flush();
				fileOutputStream.close();
			}
			//
			result.setSuccess(true);
		}
		catch (IOException | FileUploadException e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
			e.printStackTrace();
		}
		//
		return new JsonRepresentation(result.asJSON());
	}
	
}
