package org.cognizant.disastermanagement.controller;

import org.cognizant.disastermanagement.dto.request.UserRequestDTO;
import org.cognizant.disastermanagement.entity.User;
import org.cognizant.disastermanagement.service.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // ✅ CREATE USER WITH VALIDATION
    @PostMapping("/createUser")
    public User createUser(@Valid @RequestBody UserRequestDTO requestDTO) {

        User user = new User();
        user.setName(requestDTO.getName());
        user.setRole(requestDTO.getRole());
        user.setEmail(requestDTO.getEmail());
        user.setPhone(requestDTO.getPhone());
        user.setPasswordHash(requestDTO.getPasswordHash());
        user.setStatus(requestDTO.getStatus());

        return userService.createUser(user);
    }

    @GetMapping("/getByUserId/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // ✅ UPDATE USER WITH VALIDATION
    @PutMapping("/update/{id}")
    public User updateUser(
            @PathVariable int id,
            @Valid @RequestBody UserRequestDTO requestDTO) {

        User user = new User();
        user.setUserId(id);
        user.setName(requestDTO.getName());
        user.setRole(requestDTO.getRole());
        user.setEmail(requestDTO.getEmail());
        user.setPhone(requestDTO.getPhone());
        user.setPasswordHash(requestDTO.getPasswordHash());
        user.setStatus(requestDTO.getStatus());

        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        System.out.println("user deleted");
    }
}