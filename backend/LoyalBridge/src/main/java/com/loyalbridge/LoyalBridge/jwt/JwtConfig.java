package com.loyalbridge.LoyalBridge.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "application.jwt")
public class JwtConfig {
    private String secretKey;
    private String tokenPrefix;
    private Integer tokenExpirationInMinutes;

    public JwtConfig(String secretKey, String tokenPrefix, Integer tokenExpirationInMinutes) {
        this.secretKey = secretKey;
        this.tokenPrefix = tokenPrefix;
        this.tokenExpirationInMinutes = tokenExpirationInMinutes;
    }

    public JwtConfig() {
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getTokenPrefix() {
        return tokenPrefix;
    }

    public void setTokenPrefix(String tokenPrefix) {
        this.tokenPrefix = tokenPrefix;
    }

    public Integer getTokenExpirationInMinutes() {
        return tokenExpirationInMinutes;
    }

    public void setTokenExpirationInMinutes(Integer tokenExpirationInMinutes) {
        this.tokenExpirationInMinutes = tokenExpirationInMinutes;
    }
}
