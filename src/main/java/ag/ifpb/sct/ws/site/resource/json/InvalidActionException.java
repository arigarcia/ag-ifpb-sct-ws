package ag.ifpb.sct.ws.site.resource.json;

@SuppressWarnings("serial")
public class InvalidActionException extends Exception {
  
  public InvalidActionException() {
    super("Ação inválida!");
  }

}
