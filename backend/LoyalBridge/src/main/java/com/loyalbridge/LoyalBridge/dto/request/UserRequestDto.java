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
public class UserRequestDto {

    private String name;
    private String phoneNumber;
    private Boolean status;
    private Boolean highRisk;
    private Boolean verified;
    private String email;
    private String password;
    // private Integer points;
}
