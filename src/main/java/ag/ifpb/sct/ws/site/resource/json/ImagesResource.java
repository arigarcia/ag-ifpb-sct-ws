package ag.ifpb.sct.ws.site.resource.json;

import java.util.List;

import org.json.JSONArray;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import ag.ifpb.sct.ws.model.Image;
import ag.ifpb.sct.ws.model.ImageRepository;

public class ImagesResource extends ServerResource {
	private final ImageRepository imageRepository = new ImageRepository();
	
	@Get
	public JsonRepresentation listAll(){
		JSONResult result = new JSONResult();
		//
		List<Image> l = imageRepository.list();
		//
		JSONArray a = new JSONArray();
		for (Image image : l) {
	    a.put(image.getName());
    }
		//
		result.setData(a);
		result.setSuccess(true);
		result.setMessage("Listagem realizada com sucesso.");
		return new JsonRepresentation(result.asJSON());
	}
	
}
