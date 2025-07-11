package com.loyalbridge.LoyalBridge.security;

public enum ApplicationUserPermission {
    PRODUCT_READ("product:read"),
    PRODUCT_WRITE("product:write"),
    ORDER_READ("order:read"),
    ORDER_WRITE("order:write"),
    USER_ROLE_WRITE("userRole:write"),
    USER_MANAGE("user:manage"),
    USER_FREEZE("user:freeze"),
    USER_FLAG_HIGH_RISK("user:flagHighRisk");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
