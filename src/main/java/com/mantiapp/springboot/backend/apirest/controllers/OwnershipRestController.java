package com.mantiapp.springboot.backend.apirest.controllers;

import com.mantiapp.springboot.backend.apirest.models.entity.Ownership;
import com.mantiapp.springboot.backend.apirest.models.services.IOwnershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class OwnershipRestController {

    @Autowired
    private IOwnershipService ownershipService;

    /* List of urls with their uses */
    @GetMapping("/ownership")
    public List<Ownership> index() {
        return ownershipService.findAll();
    }

}
