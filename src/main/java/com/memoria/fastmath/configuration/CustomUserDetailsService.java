package com.memoria.fastmath.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.memoria.fastmath.model.DBUser;
import com.memoria.fastmath.repository.DBRoleRepository;
import com.memoria.fastmath.repository.DBUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private DBUserRepository dbUserRepository;

    @Autowired
    private DBRoleRepository dbRoleRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DBUser user = dbUserRepository.findByUsername(username);
        
        return new User(user.getUsername(), user.getPassword(), getGrantedAuthorities(user.getRoleId()));
    }

    private List<GrantedAuthority> getGrantedAuthorities(Integer roleId) {
        var role = dbRoleRepository.findById(roleId);
        if (role.isPresent()) {
        	return role.get().getAuthorities();
        }
        return new ArrayList<GrantedAuthority>();
    }
}