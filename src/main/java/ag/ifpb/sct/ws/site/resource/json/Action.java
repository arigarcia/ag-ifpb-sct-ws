package ag.ifpb.sct.ws.site.resource.json;


public interface Action<R> {
  R execute(Object... value) throws ExecutionException;
}
