package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Principal extends Controller {

    public Result index() {
        return ok(index.render());
    }

}
