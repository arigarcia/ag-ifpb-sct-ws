package ag.ifpb.sct.ws.model;


public class Image {
	private final String name;
	private final byte[] data;
	private boolean processed = false;
	
	public Image(String name, byte[] data) {
	  this.name = name;
	  this.data = data;
  }
	
	public String getName() {
	  return name;
  }
	
	public byte[] getData() {
	  return data;
  }
	
	public long getLength(){
		return data.length;
	}
	
	public void markAsProcessed(){
		processed = true;
	}
	
	public boolean isProcessed() {
	  return processed;
  }

	@Override
  public int hashCode() {
	  return name.hashCode();
  }

	@Override
  public boolean equals(Object obj) {
	  if (this == obj)
		  return true;
	  if (obj == null)
		  return false;
	  if (getClass() != obj.getClass())
		  return false;
	  Image other = (Image) obj;
	  return other.name.equals(this.name);
  }
	
}
