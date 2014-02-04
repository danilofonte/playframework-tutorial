package jobs;

import java.util.Date;

import models.Post;
import models.User;

import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class UserJobs extends Job {
 
    public void doJob() {
        // Check if the database is empty
        if(User.count() == 0) {
        	User danilo = new User("Danilo","d.fonte@f.com.br","123",true).save();        	
        	Post post = new Post("titulo",new Date(),"teste",danilo).save();
        	post.addComment("ze", "blabla");
        	post.addComment("ninbguem", "asudsahudh");
        	post.addTag("Teste");
        	post.addTag("Blog");
        	post.addTag("nome");
        	post.save();
        	
        	Post post2 = new Post("titulo2",new Date(),"teste2",danilo).save();
        	post2.addComment("ze2", "blabla2");
        	post2.addComment("ninbguem2", "asudsahudh2");
        	post2.addTag("Teste");
        	post2.addTag("nome");
        	post2.save();
        	
        }
    }

}
