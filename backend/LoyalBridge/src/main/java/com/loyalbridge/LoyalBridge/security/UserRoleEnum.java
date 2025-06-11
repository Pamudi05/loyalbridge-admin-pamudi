package com.loyalbridge.LoyalBridge.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.google.common.collect.Sets;

public enum UserRoleEnum {
    SUPER_ADMIN(Sets.newHashSet(
        ApplicationUserPermission.PRODUCT_READ,
        ApplicationUserPermission.PRODUCT_WRITE,
        ApplicationUserPermission.ORDER_READ,
        ApplicationUserPermission.ORDER_WRITE,
        ApplicationUserPermission.USER_ROLE_WRITE,
        ApplicationUserPermission.USER_MANAGE,
        ApplicationUserPermission.USER_FREEZE,
        ApplicationUserPermission.USER_FLAG_HIGH_RISK
    )),
    FINANCE_TEAM(Sets.newHashSet(
        ApplicationUserPermission.ORDER_READ
    )),
    SUPPORT_STAFF(Sets.newHashSet(
        ApplicationUserPermission.USER_MANAGE,
        ApplicationUserPermission.USER_FREEZE,
        ApplicationUserPermission.USER_FLAG_HIGH_RISK
    )),
    PARTNER_ADMIN(Sets.newHashSet(
        ApplicationUserPermission.ORDER_READ
    ));

    private final Set<ApplicationUserPermission> applicationUserPermissions;

    UserRoleEnum(Set<ApplicationUserPermission> applicationUserPermissions) {
        this.applicationUserPermissions = applicationUserPermissions;
    }

    public Set<ApplicationUserPermission> getUserPermissions() {
        return applicationUserPermissions;
    }

    public Set<SimpleGrantedAuthority> grantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getUserPermissions()
                .stream().map(permission ->
                        new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(
                new SimpleGrantedAuthority("ROLE_" + this.name())
        );
        return permissions;
    }
}
