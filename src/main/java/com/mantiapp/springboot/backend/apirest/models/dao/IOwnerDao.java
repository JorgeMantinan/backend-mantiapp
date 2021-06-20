package com.mantiapp.springboot.backend.apirest.models.dao;

import com.mantiapp.springboot.backend.apirest.models.entity.Owner;
import org.springframework.data.repository.CrudRepository;

public interface IOwnerDao extends CrudRepository<Owner, Long>{

}
