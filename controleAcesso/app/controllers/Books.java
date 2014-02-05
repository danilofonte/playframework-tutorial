package controllers;

import models.User;
import play.mvc.Before;
import play.mvc.With;

@With(Secure.class)
public class Books extends CRUD {
	
	@Before
	static void setConnectedUser() {
		if (Security.isConnected()) {
			User user = User.find("byEmail", Security.connected()).first();
			renderArgs.put("user", user.email);
		} else {
			Application.index();
		}
	}

}
