package com.scm.entities;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class SocialLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private  String title;
    private String link;

    @ManyToOne
    private  Contact contact;

}
