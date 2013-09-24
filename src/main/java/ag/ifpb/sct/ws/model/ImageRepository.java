package ag.ifpb.sct.ws.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImageRepository {
	private final static List<Image> IMAGES = new ArrayList<>();
	
	public void store(Image image){
		IMAGES.add(image);
	}
	
	public List<Image> list(){
		List<Image> images = new ArrayList<Image>();
		for (Image i : IMAGES) {
	    if (!i.isProcessed()){
	    	images.add(i);
	    }
    }
		return Collections.unmodifiableList(images);
	}
	
}
