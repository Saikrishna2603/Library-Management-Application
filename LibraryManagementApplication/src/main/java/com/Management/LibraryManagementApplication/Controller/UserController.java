package com.Management.LibraryManagementApplication.Controller;

import com.Management.LibraryManagementApplication.Entity.User;
import com.Management.LibraryManagementApplication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController
{
    @Autowired
    private UserService userService;
    @GetMapping
    private List<User> getAllUsers()
    {
        return userService.findAllUsers();
    }
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user)
    {
        return userService.save(user);
    }
}
