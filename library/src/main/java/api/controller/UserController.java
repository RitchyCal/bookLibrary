package api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import api.model.User;
import service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;




@RestController()
@RequestMapping("user")
public class UserController {
    private UserService userService;
    
    public UserController ( UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id){

        return userService.getUser(id);
    }

    @PostMapping("/ceateUser")
    public void createUser(@RequestBody User entity) {
        //TODO: process POST request
        userService.createUser(entity);
    }
    
}
