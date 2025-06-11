package com.loyalbridge.LoyalBridge.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
    private Boolean status; //Freeze, unfreeze
    @Column(name = "high_risk")
    private Boolean highRisk;
    @Column(name = "verified")
    private Boolean verified;

    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "is_account_non_expired",columnDefinition = "TINYINT")
    private boolean isAccountNonExpired;
    @Column(name = "is_account_non_locked",columnDefinition = "TINYINT")
    private boolean isAccountNonLocked;
    @Column(name = "is_credentials_non_expired",columnDefinition = "TINYINT")
    private boolean isCredentialsNonExpired;
    @Column(name = "is_enabled",columnDefinition = "TINYINT")
    private boolean isEnabled;

    @ManyToMany
    @JoinTable(name="user_user_role",
    joinColumns = @JoinColumn(name="user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<UserRole> roles;
}
