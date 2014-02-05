package functional;

import java.util.Map;

import models.User;

import org.apache.commons.collections.map.HashedMap;
import org.junit.BeforeClass;
import org.junit.Test;

import play.mvc.Http.Response;
import play.test.Fixtures;
import play.test.FunctionalTest;
import utils.UserFactory;

public class UserTest extends FunctionalTest {
	
	private static Map<String,String> param;
	
	@BeforeClass
	public void init(){
		Fixtures.delete(User.class);
		UserFactory.userValido().save();
		param = new HashedMap();
		param.put("user.email", "danilosantosfonte@gmail.com");
		param.put("user.password", "123456");
	}
	
	@Test
	public void testLoginRequest(){
		Response response = POST("/login", param);
		assertHeaderEquals("", "/main", null);
	}

}
