package utils;

import models.User;

public class UserFactory {
	
	public static User userValido(){
		return new User("danilosantosfonte@gmail.com","123456");
	}
	
	public static User userSemEmail(){
		return new User(null,"123456");
	}
	
	public static User userSemSenha(){
		return new User("danilosantosfonte@gmail.com",null);
	}
	
	public static User outroUserValido() {
		return new User("outrouser@gmail.com","123456");
	}

}
