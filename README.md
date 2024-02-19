# Xindus

Xindus is a backend application for managing wishlists. It provides APIs for user authentication and wishlist management.

## Features

- User authentication: Users can sign up, log in, and log out securely.
- Wishlist management: Users can create new wishlist items, view their existing wishlist, and delete items from the wishlist.
- Secure authentication: Authentication is handled using Spring Security to ensure secure access to user accounts and wishlists.

## Technologies Used

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- MySQL (or any preferred database)

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed
- Maven installed
- MySQL (or any preferred database) installed and running

## Usage

1. The backend application will start running on `http://localhost:8080`.
2. Use API testing tools like Postman to interact with the endpoints.
3. Sign up for a new account using the `/register` endpoint or log in with existing credentials using the `/login` endpoint.
4. Once authenticated, you can create new wishlist items using the `/api/wishlists` POST endpoint, view existing wishlist items using the `/api/wishlists` GET endpoint, and delete items from the wishlist using the `/api/wishlists/{id}` DELETE endpoint.
