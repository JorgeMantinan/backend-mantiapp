package com.mantiapp.springboot.backend.apirest.models.services;

import com.mantiapp.springboot.backend.apirest.models.dao.IOwnerDao;
import com.mantiapp.springboot.backend.apirest.models.entity.Owner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(OwnerService.class);

    @Autowired
    private IOwnerDao ownerDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Owner owner = ownerDao.findByEmail(email);

        if (owner == null){
            logger.error("Error en el login: no existe el usuario '"+email+"' en el sistema");
            throw new UsernameNotFoundException("Error en el login: no existe el usuario '"+email+"' en el sistema");
        }

        // -> is used for make it with each object, in this case with role
        List<GrantedAuthority> authorities = owner.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .peek(authority -> logger.info("Role: " + authority.getAuthority()))
                .collect(Collectors.toList());

        return new User(owner.getEmail(), owner.getPassword(), owner.getEnabled(), true, true, true, authorities);
    }

}
