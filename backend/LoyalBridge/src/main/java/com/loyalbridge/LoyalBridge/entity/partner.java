package com.loyalbridge.LoyalBridge.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "partner")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class partner {

    @Id
    private String id;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    private String apiUrl;
    private String authMethod;
    private Double conversionRate;
    private Boolean status;
}
