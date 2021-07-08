package com.mantiapp.springboot.backend.apirest.models.dao;

import com.mantiapp.springboot.backend.apirest.models.entity.Owner;
import org.springframework.data.repository.CrudRepository;

public interface IOwnershipDao  extends CrudRepository<Owner, Long> {
}
