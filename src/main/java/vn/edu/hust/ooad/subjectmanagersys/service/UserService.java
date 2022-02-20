package vn.edu.hust.ooad.subjectmanagersys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import vn.edu.hust.ooad.subjectmanagersys.config.CustomUserDetail;
import vn.edu.hust.ooad.subjectmanagersys.entity.User;
import vn.edu.hust.ooad.subjectmanagersys.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("Username " + username
					+ "not found!");
		else {
			return new CustomUserDetail(user);
		} 
	}

	public void update(User user) {
		User old = findByUsername(user.getUsername());
		user.setId(old.getId());
		user.setFullname(old.getFullname());
		user.setPassword(old.getPassword());
		userRepository.save(user);
	}
	
}
