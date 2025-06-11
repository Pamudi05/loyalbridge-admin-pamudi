package com.loyalbridge.LoyalBridge.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.loyalbridge.LoyalBridge.entity.UserRole;

public interface UserRoleRepo extends JpaRepository<UserRole, String>{

    @Query(
        value = "SELECT * FROM loyal.userRole WHERE LOWER(role_name) LIKE LOWER(CONCAT('%', :searchText, '%'))",
        nativeQuery = true
    )
    Optional<UserRole> findByRoleName(@Param("searchText") String searchText);
} 

    

