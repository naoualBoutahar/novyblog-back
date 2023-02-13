package io.novelis.novyblog;

import io.novelis.novyblog.dao.UserDao;
import io.novelis.novyblog.domain.Article;
import io.novelis.novyblog.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NovyblogApplication implements CommandLineRunner {
	@Autowired
	private UserDao user;
	public static void main(String[] args) {
		SpringApplication.run(NovyblogApplication.class, args);
	}

	@Override
	public void run(String ...args) throws Exception{
		//user.save(new User("test1","test1","test1","test1@gmail.com"));
	}



}
