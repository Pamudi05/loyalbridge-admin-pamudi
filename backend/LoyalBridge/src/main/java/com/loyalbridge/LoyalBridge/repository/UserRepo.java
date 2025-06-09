package com.loyalbridge.LoyalBridge.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.loyalbridge.LoyalBridge.entity.User;

public interface UserRepo extends JpaRepository<User, String>{
    @Query(
        value = "SELECT * FROM loyal.users WHERE LOWER(name) LIKE LOWER(CONCAT('%', :searchText, '%'))",
        countQuery = "SELECT COUNT(*) FROM loyal.users WHERE LOWER(name) LIKE LOWER(CONCAT('%', :searchText, '%'))",
        nativeQuery = true
    )
    Page<User> searchAllUsers(@Param("searchText") String searchText, Pageable pageable);

    @Query(
        value = "SELECT COUNT(*) FROM loyal.users WHERE LOWER(name) LIKE LOWER(CONCAT('%', :searchText, '%'))",
        nativeQuery = true
    )
    long countAllUsers(@Param("searchText") String searchText);
    
} 
