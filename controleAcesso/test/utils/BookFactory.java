package utils;

import java.util.Date;

import models.Book;
import models.User;

public class BookFactory {
	
	public static Book novoLivro(User user){
		return new Book("Novo Livro",new Date(),user);
	}

}
