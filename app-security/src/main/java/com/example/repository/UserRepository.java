package com.example.repository;

import com.example.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, BigInteger> {

    @Query("SELECT u FROM UserEntity u JOIN FETCH u.authorities WHERE u.email = :email")
    UserEntity findByEmail(@Param("email") String email);
}
