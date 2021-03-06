package controllers;

import java.lang.annotation.Annotation;


import models.User;

public class Security extends Secure.Security{
	
    static boolean authenticate(String username, String password) {
        return true;
    }
    
    static void onDisconnected() {
        Application.index();
    }
    
    static void onAuthenticated() {
        Admin.index();
    }
    
    static String connected(String username){
    	return username;
    }
    
    static boolean connectedOn(){
    	System.out.println(Security.connected());
    	return Security.connected() != null && Security.connected().equals("") ? true : false;
    }
    
    static boolean check(String profile) {
        if("admin".equals(profile)) {
            return User.find("byEmail", connected()).<User>first().isAdmin;
        }
        return false;
    }

	
    
}
