package com.loyalbridge.LoyalBridge.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class partnerResponsedto {
    private String id;
    private String name;
    private String apiUrl;
    private String authMethod;
    private Double conversionRate;
    private Boolean status;
}
