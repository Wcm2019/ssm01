package com.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestPwd {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder =new BCryptPasswordEncoder(  );
        //$2a$10$bilUAPhSleeee8/82HRUkOzeGLWpQPFxx1qvdcl37shJ9iWXo/mH6(123)
        //$2a$10$ScKBlerkcs0KNEND/onu6e755eaxNOjw5RnsWPe8ByYwPpMhhlrli(456)
        //$2a$10$7x/7QeN4EWe9M3yRKQI.TOW1SffDJNhBzns7X5O3lXNs7ux2rWuUO(789)
        String pwd= passwordEncoder.encode("789" );

        System.out.println(pwd);
    }
}
