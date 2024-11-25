package com.scm.repositories;

import com.scm.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, String> {
//    extra method db relatedoperations
//    custom query methods
//    custom finder methods

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);



}
