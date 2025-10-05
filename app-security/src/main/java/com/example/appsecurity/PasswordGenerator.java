package com.example.appsecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        
        // Generar hash para "password"
        String password = "password";
        String hash = encoder.encode(password);
        
        System.out.println("=== PASSWORD GENERATOR ===");
        System.out.println("Original password: " + password);
        System.out.println("Generated hash: " + hash);
        
        // Verificar con hashes conocidos
        String[] knownHashes = {
            "$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2uheWG/igi.",
            "{bcrypt}$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2uheWG/igi."
        };
        
        System.out.println("\n=== VERIFICATION TEST ===");
        for (String testHash : knownHashes) {
            boolean matches = encoder.matches(password, testHash);
            System.out.println("Hash: " + testHash);
            System.out.println("Matches 'password': " + matches);
            System.out.println("---");
        }
        
        System.out.println("\n=== SQL UPDATE COMMAND ===");
        System.out.println("UPDATE user_entity SET password = '" + hash + "' WHERE email = 'admin@test.com';");
    }
}