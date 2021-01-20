package com.deyevma.backendForUsersStore.controller;

import com.deyevma.backendForUsersStore.exceptions.UserNotFoundException;
import com.deyevma.backendForUsersStore.model.User;
import com.deyevma.backendForUsersStore.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UsersRestControllerV1 {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public Iterable findAll(){
        return userRepository.findAll();
    }

    @GetMapping("/id/{id}")
    @PreAuthorize("hasAuthority('can.read')")// (get-request)  able only for users with "read rights"
    public User findById(@PathVariable Long id){
        return userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    @GetMapping("/nick_name/{nickName}")
    @PreAuthorize("hasAuthority('can.read')")// (get-request)  able only for users with "read rights"
    public User findByEmail(@PathVariable String nickName){
        return userRepository.findByNickName(nickName)
                .orElseThrow(UserNotFoundException::new);
    }
}
