package com.mantiapp.springboot.backend.apirest.models.services;

import com.mantiapp.springboot.backend.apirest.models.entity.Ownership;

import java.util.List;

public interface IOwnershipService {

    public List<Ownership> findAll();

}
