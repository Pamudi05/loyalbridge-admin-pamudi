package com.loyalbridge.LoyalBridge.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.loyalbridge.LoyalBridge.entity.UserRole;
import com.loyalbridge.LoyalBridge.repository.UserRoleRepo;
import com.loyalbridge.LoyalBridge.services.UserRoleSevice;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserRoleImpl implements UserRoleSevice{

    private final UserRoleRepo userRoleRepo;

    @Override
    public void initializeRoles() {
        List<UserRole> userRoles = userRoleRepo.findAll();
        if(userRoles.isEmpty()){
            UserRole superAdmin = UserRole.builder()
                    .roleId(UUID.randomUUID().toString())
                    .roleName("SUPER_ADMIN")
                    .build();

            UserRole financeTeam = UserRole.builder()
                    .roleId(UUID.randomUUID().toString())
                    .roleName("FINANCE_TEAM")
                    .build();
            
            UserRole supportStaff = UserRole.builder()
                    .roleId(UUID.randomUUID().toString())
                    .roleName("SUPPORT_STAFF")
                    .build();

            UserRole PartnerAdmin = UserRole.builder()
                    .roleId(UUID.randomUUID().toString())
                    .roleName("PARTNER_ADMIN")
                    .build();

            userRoleRepo.saveAll(List.of(superAdmin,financeTeam,supportStaff,PartnerAdmin));
        }
    }

}
