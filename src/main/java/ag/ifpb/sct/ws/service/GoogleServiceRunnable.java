package ag.ifpb.sct.ws.service;

import java.io.ByteArrayInputStream;

import ag.googledrive.DriveFileMetadata;
import ag.googledrive.DriveService;
import ag.googledrive.DriveServiceException;
import ag.googledrive.DriveServiceImpl;
import ag.ifpb.sct.ws.model.Image;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.services.drive.model.File;

public class GoogleServiceRunnable implements Runnable {
	private final static String TOKEN = "ya29.AHES6ZQx9jY3jwDrZiw4IGRMZZHVb14Gdvl6ivFRI43Pg8OvMs7z2f8";
	private final DriveService service;
	private final Image image;
	
	public GoogleServiceRunnable(Image image) {
		GoogleCredential.Builder builder =  new GoogleCredential.Builder();
		GoogleCredential credential = builder.build();
		credential.setAccessToken(TOKEN);
		//
		this.service = new DriveServiceImpl(credential);
		this.image = image;
  }

	@Override
	public void run() {
		//
		ByteArrayInputStream bais = new ByteArrayInputStream(image.getData());
		//
		DriveFileMetadata metadata = new DriveFileMetadata(bais, 0);
		metadata.setTitle(image.getName());
		metadata.setDescription("File uploaded by AG IFPB SCT - " + image.getName());
		metadata.setMimeType("image/jpg");
		metadata.setParentId("0Bw9MWtYqgHkBTll1blRETjFvUnM");
		metadata.setFileExtension("jpg");
		//
    try {
    	File f = service.create(metadata);
	    System.out.println("File: " + f.getId());
    } 
    catch (DriveServiceException e) {
	    if (e.getMessage().contains("401")){
	    	
	    }
    }
	}

}
