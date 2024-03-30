package com.ecombackend.ecomproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecombackend.ecomproject.model.User;
import com.ecombackend.ecomproject.repository.UserRepository;
import com.ecombackend.ecomproject.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    @CrossOrigin
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    
    @PostMapping("/login")
    @CrossOrigin
    public ResponseEntity<String> login(@RequestBody User loginDetails){
		try {
			User user= null;
			user = userService.findUserByUsernameAndPassword(loginDetails.getUsername(),loginDetails.getPassword());
			if (user != null && user.getPassword().equals(loginDetails.getPassword())) {
            return ResponseEntity.ok("User authenticated");
			}
            else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid username or password");
            }

		} catch (Throwable e) {
			System.out.println("exception occured");
			e.printStackTrace();
			return null;
		}
        
    }

}