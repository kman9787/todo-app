package dev.kash.todoapp;

import dev.kash.todoapp.domain.User;
import dev.kash.todoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TodoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoAppApplication.class, args);
	}

	/*@Bean
	CommandLineRunner commandLineRunner(@Autowired UserRepository userRepository,
										@Autowired PasswordEncoder passwordEncoder){
		return args -> {
			// Bootstrap code here
			String passString = passwordEncoder.encode("password");

			if(userRepository.findByUserName("admin").isEmpty()) {
				userRepository.save(new User("admin", passString, "ADMIN,USER"));
			}

			if(userRepository.findByUserName("user").isEmpty()) {
				userRepository.save(new User("user", passString, "USER"));
			}
		};
	}*/
}
