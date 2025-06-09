package com.loyalbridge.LoyalBridge.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "users", schema = "loyal")
public class User {

    @Id
    @Column(name = "user_id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "high_risk")
    private Boolean highRisk;
    @Column(name = "verified")
    private Boolean verified;
    @Column(name = "points")
    private Integer points;
}
