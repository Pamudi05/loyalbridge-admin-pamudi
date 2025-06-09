package com.loyalbridge.LoyalBridge.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.loyalbridge.LoyalBridge.entity.Partner;

public interface PartnerRepo extends JpaRepository<Partner, String>{
    @Query(
        value = "SELECT * FROM loyal.partner WHERE LOWER(name) LIKE LOWER(CONCAT('%', :searchText, '%'))",
        countQuery = "SELECT COUNT(*) FROM loyal.partner WHERE LOWER(name) LIKE LOWER(CONCAT('%', :searchText, '%'))",
        nativeQuery = true
    )
    Page<Partner> searchAllPartners(@Param("searchText") String searchText, Pageable pageable);

    @Query(
        value = "SELECT COUNT(*) FROM loyal.partner WHERE LOWER(name) LIKE LOWER(CONCAT('%', :searchText, '%'))",
        nativeQuery = true
    )
    long countAllPartners(@Param("searchText") String searchText);
}