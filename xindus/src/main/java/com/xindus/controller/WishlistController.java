package com.xindus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xindus.entity.User;
import com.xindus.entity.WishlistItem;
import com.xindus.repository.UserRepository;
import com.xindus.repository.WishlistItemRepository;

@RestController
@RequestMapping("/api/wishlists")
public class WishlistController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private WishlistItemRepository wishlistItemRepository;

	@PostMapping
	public ResponseEntity<String> createWishlistItem(@RequestBody WishlistItem wishlistItem) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null && authentication.isAuthenticated()) {
			String username = authentication.getName();
			Optional<User> optionalUser = userRepository.findByUsername(username);

			if (optionalUser.isPresent()) {
				User user = optionalUser.get();
				wishlistItem.setUser(user);
				wishlistItemRepository.save(wishlistItem);
				return ResponseEntity.ok("Wishlist item created successfully.");
			}
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
	}


}
