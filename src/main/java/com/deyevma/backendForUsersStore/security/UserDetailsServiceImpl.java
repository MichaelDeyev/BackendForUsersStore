package com.deyevma.backendForUsersStore.security;

import com.deyevma.backendForUsersStore.model.User;
import com.deyevma.backendForUsersStore.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String nickName) { //not available to find by id, because of UserDetailsService implementation
        User user = userRepository.findByNickName(nickName).orElseThrow(() -> new UsernameNotFoundException("User does not exist"));
        return SecurityUser.userFromDBToRealUserMapper(user);
    }
}
