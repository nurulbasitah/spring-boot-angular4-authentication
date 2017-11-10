package com.social.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.social.entities.User;
import com.social.services.UserService;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class UserServiceTest {

	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private UserService userService;

	@Test
	public void testSave() {

		User user = new User();
		user.setUsername("user.user");
		user.setFullName("kamalbberriga");
		entityManager.persist(user);
		entityManager.flush();
		// when
		User testUser = userService.find(user.getId());
		// then
		assertThat(testUser.getFullName()).isEqualTo(user.getFullName());
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented"); // TODO
	}

}
