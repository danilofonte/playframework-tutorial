package controllers;

import play.*;
import play.data.validation.Valid;
import play.i18n.Messages;
import play.mvc.*;
import play.mvc.Scope.Flash;

import java.util.*;

import models.*;

public class Application extends Controller {

	public static void index() {
		redirect("/Secure/login");
	}
	
	public static void login() {
		if (Security.isConnected())
			Admin.main();
		else {
			flash.error("erro.login", Security.isConnected());
			Application.index();
		}
	}

	public static void cadastro(){		
		render();
	}

	public static void cadastroSubmit(@Valid User user) {
		if (validation.hasErrors()) {
			params.flash();
			validation.keep();			
			Application.cadastro();
		} else {
			user.save();
			flash.success("cadastro.sucesso", user);
			redirect("/Secure/login");
		}
		render(user);

	}

}