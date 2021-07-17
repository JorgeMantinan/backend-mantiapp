package com.mantiapp.springboot.backend.apirest.models.dao;

import com.mantiapp.springboot.backend.apirest.models.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface IRoleDao extends CrudRepository<Role,Long> {

}
