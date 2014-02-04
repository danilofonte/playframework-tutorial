package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Post extends Model{

	@Required
	public String title;
	
	@Required
	public Date postedAt;
	
	@Lob
	@Required
	@MaxSize(1000)
	public String content;
	
	@ManyToOne
	@Required
	public User author;
	
	@OneToMany(mappedBy="post",cascade=CascadeType.ALL)
	public List<Comment> comments;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	public Set<Tag> tags;

	public Post(String title, Date postedAt, String content, User author) {
		super();
		this.title = title;
		this.postedAt = postedAt;
		this.content = content;
		this.author = author;
		this.comments = new ArrayList<Comment>();
		this.tags = new TreeSet<Tag>();
	}
	
	public Post addComment(String author, String content){
		Comment comment = new Comment(this, author, content).save();
		this.comments.add(comment);
		this.save();
		return this;
	}
	
	public Post previous() {
	    return Post.find("postedAt < ? order by postedAt desc", postedAt).first();
	}
	 
	public Post next() {
	    return Post.find("postedAt > ? order by postedAt asc", postedAt).first();
	}
	
	public Post tagItWith(String name){
		tags.add(Tag.criaEBuscaPorNome(name));
		return this;
	}
	
	public static List<Post> findTaggedWith(String tag) {
	    return Post.find(
	        "select distinct p from Post p join p.tags as t where t.name = ?", tag
	    ).fetch();
	}
	
	public Post addTag(String name){
		Tag tag = new Tag(name).save();
		this.tags.add(tag);
		this.save();
		return this;
	}

	@Override
	public String toString() {
		return this.title;
	}
	
	

	
	

	
}
