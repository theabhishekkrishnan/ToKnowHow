package com.toknowhow.education;

import com.toknowhow.education.model.User;
import com.toknowhow.education.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class EducationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EducationApplication.class, args);
	}

	@Bean
	public CommandLineRunner initAdmin(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if (!userRepository.findByUsername("admin").isPresent()) {
				User admin = new User();
				admin.setUsername("admin");
				admin.setPassword(passwordEncoder.encode("admin123"));
				admin.setFullName("System Administrator");
				admin.setEmail("admin@toknowhow.com");
				admin.setRole("ROLE_ADMIN");
				userRepository.save(admin);
				System.out.println("Default admin user created: admin / admin123");
			}
		};
	}

}
