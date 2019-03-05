package kr.co.woosuk.oauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.woosuk.oauth.entity.User;;

public interface UserRepository extends JpaRepository<User,Long>{

	User findByusername(String username);

}
