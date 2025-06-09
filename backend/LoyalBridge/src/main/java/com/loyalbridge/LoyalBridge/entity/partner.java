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
@Table(name = "partner" , schema = "loyal")
public class Partner {

    @Id
    @Column(name = "partner_id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "api_url")
    private String apiUrl;
    @Column(name = "auth_method")
    private String authMethod;
    @Column(name = "conversion_rate")
    private Double conversionRate;
    @Column(name = "status")
    private Boolean status;
}
