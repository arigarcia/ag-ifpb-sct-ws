package ag.ifpb.sct.ws.site.resource.json;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONResult {
	private final JSONObject jsonObject;
	private final long initialTime = System.currentTimeMillis();
	
	public JSONResult(JSONObject json) {
		jsonObject = json;
	}
	
	public JSONResult() {
		jsonObject = new JSONObject();
		setMessage("No message.");
		setSuccess(false);
	}
	
	public void setMessage(String message){
		try {
			jsonObject.put("message", message);
		} 
		catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public void setSuccess(boolean success){
		try {
			jsonObject.put("success", success);
		} 
		catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public void setTime(long time){
		try {
			jsonObject.put("time", time);
		} 
		catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public void setData(Object data){
		try {
			jsonObject.put("data", data);
		} 
		catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public JSONObject asJSON(){
		setTime(System.currentTimeMillis() - initialTime);
		return jsonObject;
	}
	
}
