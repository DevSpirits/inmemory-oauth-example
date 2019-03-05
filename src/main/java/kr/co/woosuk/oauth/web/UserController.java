package kr.co.woosuk.oauth.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.woosuk.oauth.entity.User;
import kr.co.woosuk.oauth.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<User> listUser() throws Exception{
		return userService.selectUserList();
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public User create(User user) throws Exception{
		return userService.createUser(user);
	}
	
	@RequestMapping(value ="/user/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable(value = "id") Long id) throws Exception{
		userService.deleteUser(id);
		return "success";
	}
}
