package com.example.servingwebcontent.dto.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN, MASTER;

    @Override
    public String getAuthority() {
        return name();
    }
}
