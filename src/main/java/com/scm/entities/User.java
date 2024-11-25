package com.scm.entities;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Entity(name = "user")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements UserDetails {

    @Id
    private String userId;
    @Column(name = "user_name", nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    @Getter(value =  AccessLevel.NONE)
    private String password;
    @Column(length = 1000000)
    private  String about;
    @Column(length = 1000000)
    private String profilePic;
    private String phoneNumber;

@Getter(value =  AccessLevel.NONE)
//    Information
    private boolean enabled = true;
    private  boolean emailVerified = false;
    private boolean phoneVerified = false;

//    Self , google, facebook
@Enumerated(EnumType.STRING)
    private Providers provider=Providers.SELF;
    private Providers providerUserId;

//    add more fields if needed
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Contact> contacts = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String>roleList = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> roles = roleList.stream().map(role -> new SimpleGrantedAuthority(role))
                .collect(Collectors.toList());
        return roles;
    }

    @Override
    public String getPassword() {
        return "";
    }


    //    for this project we used email as username
    @Override
    public String getUsername() {

        return this.email;
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
    public boolean isEnabled(){
        return this.enabled;
    }

}