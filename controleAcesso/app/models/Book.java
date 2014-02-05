package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Book extends Model implements Comparable<Book> {
	
	@Required
	public String title;
		
	public Date yearPublication;
	
	@Required
	@ManyToOne
	public User owner;

	public Book(String title, Date yearPublication, User owner) {
		super();
		this.title = title;
		this.yearPublication = yearPublication;
		this.owner = owner;
	}

	@Override
	public int compareTo(Book o) {
		return title.compareTo(o.title);
	}
	
	
	
	

}
