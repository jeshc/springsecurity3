package com.jeshc.carssec.repository;

import com.jeshc.carssec.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);
}
