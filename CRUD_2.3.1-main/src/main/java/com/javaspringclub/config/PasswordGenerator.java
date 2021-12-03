package com.javaspringclub.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {// сдесь делал шифровку паролей, чтоб на сайт не лезть )


        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String rawPassword = "100";
            String encodedPassword = bCryptPasswordEncoder.encode(rawPassword);
        System.out.println(encodedPassword);
        }
    }

