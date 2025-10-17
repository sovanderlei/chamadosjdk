package com.api.chamadosjdk.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO: Implementar busca real no banco de dados
        // Por enquanto, usuário fixo para teste
        if ("admin".equals(username)) {
            return new User(
                "admin",
                "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6", // password: password
                List.of(new SimpleGrantedAuthority("SCOPE_ROLE_USER")) // desta forma usuario admin(SCOPE_ROLE_USER) poderar acessar 
            );
        } else {
            throw new UsernameNotFoundException("Usuário não encontrado: " + username);
        }
    }
}