package com.example.servingwebcontent.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN, MASTER;

    @Override
    public String getAuthority() {
        return name();
    }
}
