package com.xindus.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<WishlistItem> wishlistItem;

	public User() {
	}

	public User(String username, String password, List<WishlistItem> wishlistItem) {
		super();
		this.username = username;
		this.password = password;
		this.wishlistItem = wishlistItem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<WishlistItem> getWishlistItem() {
		return wishlistItem;
	}

	public void setWishlistItem(List<WishlistItem> wishlistItem) {
		this.wishlistItem = wishlistItem;
	}
}
