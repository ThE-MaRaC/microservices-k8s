package hr.mhercog.usermanagementservice.service;

import java.util.List;

import hr.mhercog.usermanagementservice.model.User;

public interface UserService {
	User save(User user);

	User findById(Long id);

	List<User> findAll();

	User findByUsername(String username);
}
