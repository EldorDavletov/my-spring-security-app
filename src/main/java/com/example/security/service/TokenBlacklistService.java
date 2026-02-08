package com.example.security.service;

import com.example.security.entity.TokenBlacklist;
import com.example.security.repository.TokenBlacklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class TokenBlacklistService {

    @Autowired
    private TokenBlacklistRepository tokenBlacklistRepository;

    public void addTokenToBlacklist(String token, LocalDateTime expiryDate) {
        TokenBlacklist blacklistedToken = new TokenBlacklist(token, expiryDate);
        tokenBlacklistRepository.save(blacklistedToken);
    }

    public boolean isTokenBlacklisted(String token) {
        return tokenBlacklistRepository.existsByToken(token);
    }

    public void removeExpiredTokens() {
        // This can be scheduled to run periodically
        LocalDateTime now = LocalDateTime.now();
        // Implementation to remove expired tokens from blacklist
    }
}