package ag.ifpb.sct.ws.site.resource.json;


public abstract class AbstractAction<R> implements Action<R> {
  protected final String token;
  protected final String userId;

  public AbstractAction(String token, String userId) {
    this.token = token;
    this.userId = userId;
  }

}
