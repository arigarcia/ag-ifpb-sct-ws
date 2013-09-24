package ag.ifpb.sct.ws.site.resource.json;

import ag.ifpb.sct.ws.site.resource.html.AbstractResource;

/**
 * Gerencia a recepção dos dados relacionados às ações de: 
 * - compartilhar imagem (share) 
 * 
 * @author ari
 * 
 */
public class ActionResource extends AbstractResource {

//  private JSONResult process(Object value) throws JSONException {
//    //token
//    String sesseionId = SessionService.getId(getRequest());
//    //spring context
//    ApplicationContext ctx = SpringContext.getContext();
//    //facebook token
//    AccessService accessService = ctx.getBean(AccessService.class);
//    Access access = accessService.get(sesseionId);
//    //
//    JSONResult result = new JSONResult();
//    try {
//      // recover action
//      String actionName = getAttribute("actionName");
//      // create action
//      ActionFactory actionFactory = new ActionFactory();
//      Action<?> action = actionFactory.create(
//          actionName, access.getFacebookToken(), access.getUserId()
//      );
//      Object obj = action.execute(value);
//      //set result
//      result.setSuccess(true);
//      result.setMessage("Ação realizada com sucesso!");
//      result.setData(obj);
//      //activity
//      FObject fo = (FObject) obj;
//      CodeFactory factory = ctx.getBean(CodeFactory.class);
//      //
//      String code = factory.code("AB");
//      String userid = access.getUserId();
//      String username = access.getUserName();
//      String actionname = actionName;
//      String message = fo.getMessage();
//      String objid = fo.getObject();
//      //
//      Activity activity = new Activity(code, userid, username, objid, actionname, message);
//      ActivityService activityService = ctx.getBean(ActivityService.class);
//      activityService.register(activity);
//    }
//    catch (InvalidActionException e) {
//      result.setSuccess(false);
//      result.setMessage(e.getMessage());
//    } 
//    catch (ExecutionException e) {
//      result.setSuccess(false);
//      result.setMessage(e.getMessage());
//    }
//    //
//    return result;
//  }
//  
//  @Post
//  public JsonRepresentation act(JsonRepresentation representation) throws IOException {
//    JSONResult result = new JSONResult();
//    try {
//      JsonRepresentation rep = new JsonRepresentation(representation);
//      result = process(rep.getJsonObject());
//    }
//    catch (JSONException e) {
//      result.setSuccess(false);
//      result.setMessage("Formato de dados desconhecido. Mensagem de Erro: " + e.getMessage());
//    }
//    return new JsonRepresentation(result.asJSON());
//  }
//  
//  @Get
//  public JsonRepresentation act() throws IOException {
//    JSONResult result = new JSONResult();
//    try {
//      String filterId = (String) getRequestAttributes().get("filterId");
//      result = process(filterId);
//    }
//    catch (JSONException e) {
//      result.setSuccess(false);
//      result.setMessage("Formato de dados desconhecido. Mensagem de Erro: " + e.getMessage());
//    }
//    return new JsonRepresentation(result.asJSON());
//  }

}
