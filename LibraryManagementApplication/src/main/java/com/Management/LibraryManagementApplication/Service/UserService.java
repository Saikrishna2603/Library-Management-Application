package com.Management.LibraryManagementApplication.Service;

import com.Management.LibraryManagementApplication.Entity.User;
import com.Management.LibraryManagementApplication.Reposiitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
    @Autowired
    private UserRepository userrepo;

    public List<User> findAllUsers()
    {
        return userrepo.findAll();
    }
    public User save(User user)
    {
        return userrepo.save(user);
    }
}
