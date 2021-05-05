package com.example.demo;
 
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.example.demo.entities.user;
import com.example.demo.repository.userRepository;
import com.example.demo.service.userService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class  RefactorApplicationTest {

	
	@Autowired
	private userService service;
	
    @Autowired
	private MockMvc mockMvc;
	
    @MockBean
	private userRepository repository;
    
	
	@Test
	public void getuserTest() throws Exception
	{
		List<user> listuser = check_Created_UserList();
		
		String uri = "/getuser";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		ObjectMapper objectMapper = new ObjectMapper();
		String expectedJson = objectMapper.writeValueAsString(listuser);
		String outputJson = result.getResponse().getContentAsString();
		System.out.println(expectedJson);
		System.out.println(outputJson);
		assertEquals(expectedJson,outputJson);
		
	}


	private List<user> check_Created_UserList() 
	{
		List<user> listuser = new ArrayList<>();
		listuser.add(new user("zdipti","Dipti chauhan","zdip@gmail.com","aasdfg",1234567890,"asd"));
		listuser.add(new user("@lice","alice chauhan","alice@gmail.com","aasdfg",1234555678,"asd"));
		listuser.add(new user("qwerty","qwerty","zdip@gmail.com","aaswe",1187654321,"asd"));
		Mockito.when(repository.findAll()).thenReturn(listuser);
		return listuser;
	}
	
	
	private user user = new user ("zdipti","Dipti chauhan","zdip@gmail.com","aasdfg",1234567890,"asd");
	
	@Test
	public void adduserTest()
	{
		
		when(repository.save(user)).thenReturn(user);
		assertEquals(user,repository.save(user));
	}
	
	@Test
	public void updateTest()
	{
		user.setFull_name("alice");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user,repository.save(user));
	}
	
	@Test
	public void deleteuserTest()
	{
		service.deleteuser(user);
		verify(repository,times(1)).delete(user);
	}

}
