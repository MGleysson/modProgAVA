import play.*;
import play.mvc.*;	
import play.mvc.Http.*;
import play.libs.F.*;

import static play.mvc.Results.*;

public class Global extends GlobalSettings {
	
	public Promise<Result> onHandlerNotFound(RequestHeader request) {
        return Promise.<Result>pure(notFound(views.html.paginaNaoEncontrada.render(request.uri())));
    }
	
	
}
