package org.cognizant.disastermanagement.service;

import org.cognizant.disastermanagement.entity.User;
import org.cognizant.disastermanagement.dao.UserRepository;
import org.cognizant.disastermanagement.dto.request.UserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRequestDTO userRequestDTO;
    public User createUser(User user) {
        user.setPasswordHash(passwordEncoder.encode(userRequestDTO.getPasswordHash()));
        return userRepository.save(user);
    }
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTService jwtService;

    public String UserLoginValidation(User user) {
        System.out.println(user.getEmail() +" password:"+user.getPasswordHash());
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUserId().toString(),user.getPasswordHash()));
        if(authentication.isAuthenticated())
            return jwtService.generateToken(user.getUserId().toString());
        return "fail";
    }
    public User getUserById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }
}