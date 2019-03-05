package kr.co.woosuk.oauth.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.woosuk.oauth.entity.User;
import kr.co.woosuk.oauth.repository.UserRepository;
import kr.co.woosuk.oauth.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserDetailsService, UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<User> selectUserList(){
		return userRepository.findAll();
	}

	@Override
	public User createUser(User user) throws Exception {
		// TODO Auto-generated method stub
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Long id) throws Exception {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	/*@PostConstruct
	public void init() throws Exception{
		User user = userRepository.findByusername("test");
		if(user == null) {
			User initUser = new User();
			
			initUser.setUsername("test");
			initUser.setPassword("password");
			User test = createUser(initUser);
		}
	}*/

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByusername(username);
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),getAuthorities());
	}
	
	private Collection<? extends GrantedAuthority> getAuthorities(){
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}
}
