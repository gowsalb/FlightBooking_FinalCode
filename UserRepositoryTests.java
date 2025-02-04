package com.javatpoint.LoginAndRegistrationPage;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private UserRepository repo;
	
	@Test
	@Order(1)
	public void testCreateUser() {
		User user = new User();
		user.setEmail("ravikumar@gmail.com");
		user.setPassword("ravi2020");
		user.setFirstName("Ravi");
		user.setLastName("Kumar");
		user.setRole("Admin");
		User savedUser = repo.save(user);
		User existUser = entityManager.find(User.class, savedUser.getId());
		assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
		
	}
	@Test
	@Order(2)
	public void testFindByEmail() {
		String email = "ravikumar@gmail.com";
		User user = repo.findByEmail(email);
		System.out.println(user.getEmail());
		assertThat(user.getEmail()).isEqualTo(email);
	}
}
