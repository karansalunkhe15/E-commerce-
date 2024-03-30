package com.ecombackend.ecomproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecombackend.ecomproject.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    public  User findByUsernameAndPassword(String username, String password) ;
		// TODO Auto-generated method stub
	
    
//    public User checkUserCredentials(String username, String password) {
//        return userRepository.findByUsernameAndPassword(username, password);
//    }

    
    // Other methods...
}
