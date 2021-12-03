package com.javaspringclub.service;

import com.javaspringclub.entity.User;
import com.javaspringclub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @PersistenceContext
    EntityManager entityManager;

    @Autowired
   public UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {//предоставить Юзера
        // по имени пользователя из нашей БД
      //  User user = userRepository.findByUserUsername(username); // Этот Юзер наш собственный класс.
        // Он Секюрити не нужен так как много информации

        User user = userRepository.findByUsername(username);
        if (user==null){
            throw  new UsernameNotFoundException("User not found " + username);
        }
        return  new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),user.getAuthorities());

        // используем Юзера от спринга. так как ему для авторизации нужен только имя, пароль, права.

    }
}
