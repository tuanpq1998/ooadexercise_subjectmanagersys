package vn.edu.hust.ooad.subjectmanagersys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.edu.hust.ooad.subjectmanagersys.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>  {

	public User findByUsername(String username);

	
}
