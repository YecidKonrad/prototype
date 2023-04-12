package com.prototype.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.prototype.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findUserByEmail(String email);
    @Query(value="select * from acceso.USER where username in :usernames", nativeQuery = true)
    List<User> findUsersByUsername(@Param("usernames") List<String> usernames);
}
