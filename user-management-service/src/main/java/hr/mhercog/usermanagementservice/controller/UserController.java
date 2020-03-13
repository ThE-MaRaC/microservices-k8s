package hr.mhercog.usermanagementservice.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.mhercog.usermanagementservice.model.Role;
import hr.mhercog.usermanagementservice.model.User;
import hr.mhercog.usermanagementservice.service.UserService;

@RestController
@RequestMapping("/service")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody User user) {
		if (userService.findByUsername(user.getUsername()) != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		user.setRole(Role.USER);
		return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
	}

	@GetMapping("/login")
	public ResponseEntity<?> login(Principal principal) {
		if (principal == null || principal.getName() == null) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return ResponseEntity.ok(userService.findByUsername(principal.getName()));
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUser(@PathVariable Long id) {
		return ResponseEntity.ok(userService.findById(id));
	}

	@GetMapping("/users")
	public ResponseEntity<?> getUsers() {
		return ResponseEntity.ok(userService.findAll());
	}
}
