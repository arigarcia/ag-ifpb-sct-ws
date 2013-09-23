package ag.ifpb.sct.ws.site.resource.html;


public class DataResult {
	private String url;
	private Object data;
	private String page;
	private String extension;
	
	public DataResult(String url, String page) {
		this.url = url;
		this.page = page;
		this.extension = ".htpl";
	}
	
	public String getPage() {
		return page;
	}
	
	public String getUrl() {
		return url;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
	public String getExtension() {
      return extension;
    }
	
}
