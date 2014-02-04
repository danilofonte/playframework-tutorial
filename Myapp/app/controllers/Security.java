package controllers;

import java.lang.annotation.Annotation;

import models.User;

public class Security extends Secure.Security {
	
    static boolean authenticate(String username, String password) {
        return true;
    }
    
    static void onDisconnected() {
        Application.users();
    }
    
    static void onAuthenticated() {
        Admin.index();
    }
    
    static boolean check(String profile) {
        if("admin".equals(profile)) {
            return User.find("byEmail", connected()).<User>first().isAdmin;
        }
        return false;
    }

	
    
}
