package com.deyevma.backendForUsersStore.controller;

import com.deyevma.backendForUsersStore.model.User;
import com.deyevma.backendForUsersStore.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public User findById(@PathVariable Long id){
        return userRepository.findById(id);//why there isn't any elseThrow methods?
    }

    @GetMapping("/nick_name/{nickName}")
    public User findByEmail(@PathVariable String nickName){
        return userRepository.findByNickName(nickName)
                .orElseThrow();//TODO
    }

}
