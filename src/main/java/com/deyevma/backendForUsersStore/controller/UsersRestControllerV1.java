package com.deyevma.backendForUsersStore.controller;

import com.deyevma.backendForUsersStore.exceptions.UserIdMismatchException;
import com.deyevma.backendForUsersStore.exceptions.UserNotFoundException;
import com.deyevma.backendForUsersStore.model.User;
import com.deyevma.backendForUsersStore.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/{id}")
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('can.write')")// (post-request)  able only for users with "write rights"
    public User createUser(@RequestBody User user) {//TODO works but ID ignore users that have already exist, so the first user created by postman would has ID 1, not 4
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('can.write')")// (delete-request)  able only for users with "read write"
    public void deleteUser(@PathVariable Long id){//TODO doesn't work
        userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        userRepository.deleteById(id);
    }

    @PutMapping("/{id}")
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
