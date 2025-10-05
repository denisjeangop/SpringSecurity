package com.example.security;

import com.example.model.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomSecurityUser implements UserDetails {
    
    private final UserEntity userEntity;
    
    public CustomSecurityUser(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.userEntity.getAuthorities();  
    }

    @Override
    public String getUsername() {
        return this.userEntity.getEmail();  // Email como username
    }
    
    @Override
    public String getPassword() {
        return this.userEntity.getPassword();  // Password de la entidad
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
