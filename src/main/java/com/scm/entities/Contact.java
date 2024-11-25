package com.scm.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.*;


@Entity
public class Contact {
    @Id
    private  String id;
    private String name;
    private String email;
    private String phoneNUmber;
    private String address;
    private String picture;
    @Column(length = 10000)
    private String description;
    private Boolean favorite=false;
    private String instagramLink;
    private String facebookLink;
    private String websiteLink;
    private String linkedInLink;
//    private List<String>socialLinks = new ArrayList<>()

    @ManyToOne
    private  User user;

    @OneToMany(mappedBy = "contact",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<SocialLink> links = new ArrayList<>();
}
