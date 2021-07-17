package com.mantiapp.springboot.backend.apirest.models.services;

import com.mantiapp.springboot.backend.apirest.models.entity.Owner;

import java.util.List;

public interface IOwnerService {

    public List<Owner> findAll();

    public Owner findById(Long id);

    public Owner findByEmail(String email);

    public Owner save(Owner owner);

    public void delete(Long id);

}
