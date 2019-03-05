package kr.co.woosuk.oauth.service;

import java.util.List;

import kr.co.woosuk.oauth.entity.User;


public interface UserService {

	List<User> selectUserList() throws Exception;
	
	User createUser(User user) throws Exception;
	
	void deleteUser(Long id) throws Exception;
	
}
