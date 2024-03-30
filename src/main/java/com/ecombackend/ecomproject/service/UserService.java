package com.ecombackend.ecomproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecombackend.ecomproject.model.User;
import com.ecombackend.ecomproject.repository.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUserByUsernameAndPassword(String username, String password) throws Throwable {
        User user = null;
		try {
			user = userRepository.findByUsernameAndPassword(username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (user == null) {
//            ("User not found with provided username and password");
        }
        return user;
    }

    
    public User createUser(User user) {
        // Implement logic to save a new user
        return userRepository.save(user);
    }

    // Other methods...
}