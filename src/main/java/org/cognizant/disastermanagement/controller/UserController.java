package org.cognizant.disastermanagement.controller;

import org.cognizant.disastermanagement.entity.User;
import org.cognizant.disastermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        System.out.println(user.getName()+" "+user.getPasswordHash());
        return userService.createUser(user);
    }
    @PostMapping("/login")
    public String UserLoginValidation(@RequestBody  User user){
        System.out.println(user.getUserId()+" "+user.getPasswordHash());
        return userService.UserLoginValidation(user);
    }
    @GetMapping("/getByUserId/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        System.out.println(user.getPasswordHash());
        user.setUserId(id);
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        System.out.println("user delted");
    }
}