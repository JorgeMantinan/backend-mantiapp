package com.mantiapp.springboot.backend.apirest.models.services;

import com.mantiapp.springboot.backend.apirest.models.entity.Ownership;
import java.util.List;

public interface IOwnershipService {

    public List<Ownership> findAll();

    public Ownership findById(Long id);

    public Ownership save(Ownership ownership);

    public void delete(Long id);

}
