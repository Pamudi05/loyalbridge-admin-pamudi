package com.loyalbridge.LoyalBridge.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PartnerRequestDto {
    private String name;
    private String apiUrl;
    private String authMethod;
    private Double conversionRate;
    private Boolean status;
}
