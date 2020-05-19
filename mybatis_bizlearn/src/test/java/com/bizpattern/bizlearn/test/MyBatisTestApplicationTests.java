package com.bizpattern.bizlearn.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bizpattern.bizlearn.model.User;
import com.bizpattern.bizlearn.model.mapper.UserMapper;
import com.bizpattern.bizlearn.service.UserService;
import com.bizpattern.bizlearn.service.UserServiceImpl;

@SpringBootTest
class MyBatisTestApplicationTests {

	@MockBean
	UserMapper userMapperMock;

	@Test
	void contextLoads() {

		ArrayList<User> users = new ArrayList<User>();
		users.add(new User(1l, "Dinesh", "dk@yahoo.com"));
		when(userMapperMock.getAllUsers()).thenReturn(users);
		UserService userService = new UserServiceImpl(userMapperMock);
		assertThat(userService.getAllUsers().size() == 1);

	}

}
