package models;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.data.validation.Email;
import play.data.validation.Password;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class User extends Model {
	
	@Required
	public String name;
	
	@Password
	@Required
	public String password;
	
	@Required
	@Email
	public String email;
	public boolean isAdmin;
	
	public User(String name, String email, String password, boolean isAdmin) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.isAdmin = isAdmin;
	}
	
	public static User loginUser(String email, String password){
		return find("byEmailAndPassword",email,password).first();
	}

	@Override
	public String toString() {
		return this.email;
	}
	
	

}
