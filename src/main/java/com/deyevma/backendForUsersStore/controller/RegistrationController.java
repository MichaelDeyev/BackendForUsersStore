package com.deyevma.backendForUsersStore.controller;

import com.deyevma.backendForUsersStore.exceptions.UserIsAlreadyExistException;
import com.deyevma.backendForUsersStore.model.Role;
import com.deyevma.backendForUsersStore.model.Status;
import com.deyevma.backendForUsersStore.model.User;
import com.deyevma.backendForUsersStore.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.Optional;

@Controller
public class RegistrationController {

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registrationPage(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user){
        final Optional<User> userFromDB = userRepository.findByNickName(user.getNickName());
        if (userFromDB.isPresent()){
            throw new UserIsAlreadyExistException();
        } else {
            user.setStatus(Status.ONLINE);
            final String passwordNotEncoded = user.getPassword();
            user.setPassword(bCryptPasswordEncoder.encode(passwordNotEncoded));
            userRepository.save(user);
        }
        return "redirect:/login";
    }
}
