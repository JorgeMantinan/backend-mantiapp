package com.mantiapp.springboot.backend.apirest.models.dao;

import com.mantiapp.springboot.backend.apirest.models.entity.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IOwnerDao extends CrudRepository<Owner, Long>{

    public Owner findByEmail(String email);

    public Owner findByName(String name);

}
