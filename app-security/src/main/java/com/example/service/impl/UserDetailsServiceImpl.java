package com.example.service.impl;

import com.example.model.UserEntity;
import com.example.repository.UserRepository;
import com.example.security.CustomSecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("🔍 UserDetailsService: Buscando usuario: " + username);
        
        // 1. Buscar usuario en BD por email
        UserEntity userEntity = userRepository.findByEmail(username);
        
        // 2. Si no existe, lanzar excepción
        if (userEntity == null) {
            System.out.println("❌ Usuario no encontrado: " + username);
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }
        
        System.out.println("✅ Usuario encontrado: " + userEntity.getEmail());
        System.out.println("🔑 Password en BD: " + userEntity.getPassword());
        System.out.println("👥 Authorities: " + userEntity.getAuthorities().size());
        
        // 3. Convertir UserEntity → CustomSecurityUser → UserDetails
        return new CustomSecurityUser(userEntity);
    }
}
