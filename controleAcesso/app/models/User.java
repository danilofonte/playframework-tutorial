package models;

import javax.persistence.Entity;

import org.mindrot.jbcrypt.BCrypt;

import play.data.validation.Check;
import play.data.validation.CheckWith;
import play.data.validation.Email;
import play.data.validation.Required;
import play.db.jpa.Model;
import play.i18n.Messages;

@Entity
public class User extends Model {
	
	@Required(message = "&{'email.required'}")
	@Email(message = "&{'email.valido'}")	
	@CheckWith(EmailNotEquals.class)
	public String email;
	
	@Required(message = "&{'password.required'}")
	public String password;	
	
	public User() {
		
	}
	
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public static boolean connect(String email, String password){		
		User user = find("byEmail", email).first();
		if (user != null)
			return BCrypt.checkpw(password, user.password);
		else
			return false;
	}
	
	static class EmailNotEquals extends Check {		
		@Override
		public boolean isSatisfied(Object validatedObject, Object email) {
			
			if (email == null)
				return false;
			
			setMessage(Messages.get("email.utilizado"), email.toString());
			return User.find("byEmail", email).first() == null ? true : false;
		}
	}
	
	public User save() {
		
		this.password = BCrypt.hashpw(this.password, BCrypt.gensalt());
		return super.save();
	}

}
