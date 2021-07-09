package com.mantiapp.springboot.backend.apirest.models.dao;

import com.mantiapp.springboot.backend.apirest.models.entity.Ownership;
import org.springframework.data.repository.CrudRepository;

public interface IOwnershipDao  extends CrudRepository<Ownership, Long> {
}
