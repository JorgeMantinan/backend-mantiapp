package com.mantiapp.springboot.backend.apirest.controllers;

import com.mantiapp.springboot.backend.apirest.models.entity.Ownership;
import com.mantiapp.springboot.backend.apirest.models.services.IOwnershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/ownership/{id}")
    public Ownership show(@PathVariable Long id){
        return ownershipService.findById(id);
    }

    //RequestBody because is obtained of RequestBody of Json
    @PostMapping("/ownership")
    @ResponseStatus(HttpStatus.CREATED)
    public Ownership create(@RequestBody Ownership ownership){
        return ownershipService.save(ownership);
    }

    @PutMapping("/ownership/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Ownership update(@RequestBody Ownership ownership, @PathVariable Long id){
        Ownership currentOwnership = ownershipService.findById(id);

        currentOwnership.setOperation(ownership.getOperation());
        currentOwnership.setPopulation(ownership.getPopulation());
        currentOwnership.setZone(ownership.getZone());
        currentOwnership.setKindOwnership(ownership.getKindOwnership());
        currentOwnership.setBedrooms(ownership.getBedrooms());
        currentOwnership.setPrice(ownership.getPrice());

        return ownershipService.save(currentOwnership);

    }

    @DeleteMapping("/ownership/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        ownershipService.delete(id);
    }

}
