package com.scm.config;


import com.scm.services.impl.SecurityCustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
public class SecurityConfig {


    @Autowired
    private SecurityCustomUserDetailService userDetailService;
////    user create and login using java code with in memory service
////    @Bean
////    public UserDetailsService userDetailsService(){
////       UserDetails user1 =  User
////               .withDefaultPasswordEncoder()
////               .username("admin@123")
////               .password("admin@123")
//               .roles("ADMIN","USER")
////               .build();
////
////       UserDetails user2 = User.withUsername("user123")
////               .password("password")
////               .build();
////        var inMemoryUserDetailsManager = new InMemoryUserDetailsManager(user1);
////        return inMemoryUserDetailsManager;
////
//    }
//configuration of Auhtentication Provider

    @Bean
    public DaoAuthenticationProvider  authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

//        user details service ka object
        daoAuthenticationProvider.setUserDetailsService(userDetailService);
//        password encoder ka object
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;

    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

//        configuration
        httpSecurity.authorizeHttpRequests(authorize->{
//            authorize.requestMatchers("/home", "/register","/services").permitAll();
            authorize.requestMatchers("/user/**").permitAll();
            authorize.anyRequest().permitAll();
        });
        //form default login
//        agar hame kuch vi change krna hoga

        httpSecurity.formLogin(Customizer.withDefaults());
        return httpSecurity.build();

    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
