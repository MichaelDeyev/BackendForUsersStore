package com.deyevma.backendForUsersStore.controller;

import com.deyevma.backendForUsersStore.exceptions.UserIdMismatchException;
import com.deyevma.backendForUsersStore.exceptions.UserNotFoundException;
import com.deyevma.backendForUsersStore.model.User;
import com.deyevma.backendForUsersStore.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/api/v1/users/admin")
    @PreAuthorize("hasAuthority('can.write')")// (post-request)  able only for users with "write rights"
    public String findAll(Model model){
        final Iterable<User> allUsers = userRepository.findAll();
        model.addAttribute("allUsers", allUsers);
        return "adminpage";
    }

    @GetMapping("/api/v1/users/admin/{id}")
    @PreAuthorize("hasAuthority('can.write')")// (get-request)  able only for users with "write rights"
    public User findById(@PathVariable Long id){
        return userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    @PostMapping("/api/v1/users/admin")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('can.write')")// (post-request)  able only for users with "write rights"
    public User createUser(@RequestBody User user) {//TODO works but ID ignore users that have already exist, so the first user created by postman would has ID 1, not 4
        return userRepository.save(user);
    }

    @DeleteMapping("/api/v1/users/admin/{id}")
    @PreAuthorize("hasAuthority('can.write')")// (delete-request)  able only for users with "read write"
    public void deleteUser(@PathVariable Long id){//TODO doesn't work
        userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        userRepository.deleteById(id);
    }

    @PutMapping("/api/v1/users/admin/{id}")
    @PreAuthorize("hasAuthority('can.write')")// (put-request)  able only for users with "read write"
    public User updateUser(@RequestBody User user, @PathVariable Long id){//TODO had not tested yet
        if (!user.getId().equals(id)){
            throw new UserIdMismatchException();
        }
        userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        return userRepository.save(user);
    }
}
