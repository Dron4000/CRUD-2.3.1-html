package com.javaspringclub.UserDetails;

import com.javaspringclub.entity.Role;
import com.javaspringclub.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

public class MyUserDetails  implements UserDetails {

    User user;

    public MyUserDetails(User user) {
        this.user = user;
    }

    @Override
    public  Collection<? extends GrantedAuthority> getAuthorities() {//возвращает набор ролей.Роли - это просто, строки
        Set<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority>authorities = roles.stream()
                .map(r->new SimpleGrantedAuthority(r.getName()))
                .collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
