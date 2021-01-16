package com.deyevma.backendForUsersStore.security;

import com.deyevma.backendForUsersStore.model.Status;
import com.deyevma.backendForUsersStore.model.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
// autologout HERE?
// map user from DB to Security user
@Data
public class SecurityUser implements UserDetails {

    private final String username;
    private final String password;
    private final List<SimpleGrantedAuthority> authorities;
    private final boolean isActive;

    public static UserDetails userFromDBToRealUserMapper(User user){
        return new org.springframework.security.core.userdetails.User(
                user.getNickName(), user.getPassword(),
                user.getStatus().equals(Status.ONLINE),
                user.getStatus().equals(Status.ONLINE),
                user.getStatus().equals(Status.ONLINE),
                user.getStatus().equals(Status.ONLINE),
                user.getRole().getAuthorities()
        );
    }

    public SecurityUser(String username, String password, List<SimpleGrantedAuthority> authorities, boolean isActive) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.isActive = isActive;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }


}
