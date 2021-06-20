package com.mantiapp.springboot.backend.apirest.models.services;

import java.util.List;

import com.mantiapp.springboot.backend.apirest.models.entity.Owner;

public interface IOwnerService {
	
	public List<Owner> findAll();

}
