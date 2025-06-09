package com.loyalbridge.LoyalBridge.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class UserResponsedto {
    private String id;
    private String name;
    private String phoneNumber;
    private Boolean status;
    private Boolean highRisk;
    private Boolean verified;
    private Integer points;
}
