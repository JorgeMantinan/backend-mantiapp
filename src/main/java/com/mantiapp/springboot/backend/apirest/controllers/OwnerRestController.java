package com.mantiapp.springboot.backend.apirest.controllers;


import com.mantiapp.springboot.backend.apirest.models.entity.Owner;
import com.mantiapp.springboot.backend.apirest.models.services.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/* Connection with Angular */
@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class OwnerRestController {

	@Autowired
	private IOwnerService ownerService;

	/* List of urls with their uses */
	@GetMapping("/owners")
	public List<Owner> index() {
		return ownerService.findAll();
	}

}
