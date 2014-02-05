package controllers;

import models.User;
import play.i18n.Messages;

public class Security extends Secure.Security {

	static void onDisconnected() {
		Application.index();
	}
	
	static void onDisconnect(){
		Application.index();
	}

	public static void onAuthenticated() {
		Admin.main();
	}	

	public static boolean authenticate(String username, String password) {		
		return User.connect(username, password);	
	}
	
	

}
