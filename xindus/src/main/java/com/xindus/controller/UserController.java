package com.xindus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xindus.entity.User;
import com.xindus.repository.UserRepository;
import com.xindus.repository.WishlistItemRepository;
import com.xindus.utils.JwtHelper;
import com.xindus.utils.JwtRequest;
import com.xindus.utils.JwtResponse;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    private WishlistItemRepository wishlistItemRepository;

	@Autowired
	private JwtHelper jwtHelper;

	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/register")
	public String registerUser(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "User Created Success";
	}

	@PostMapping("/login")
	public JwtResponse login(@RequestBody JwtRequest request) {
		Authentication authentication = new UsernamePasswordAuthenticationToken(request.getUsername(),
				request.getPassword());
		Authentication authenticated = manager.authenticate(authentication);

		UserDetails userDetails = (UserDetails) authenticated.getPrincipal();
		String token = this.jwtHelper.generateToken(userDetails);

		JwtResponse jwtResponse = new JwtResponse(userDetails.getUsername(), token);
		return jwtResponse;
	}
	
}
