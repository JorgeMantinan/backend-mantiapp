package com.mantiapp.springboot.backend.apirest.controllers;

import com.mantiapp.springboot.backend.apirest.models.entity.Ownership;
import com.mantiapp.springboot.backend.apirest.models.services.IOwnershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
    @Secured({"ROLE_ADMIN"})
    @PostMapping("/ownership")
    @ResponseStatus(HttpStatus.CREATED)
    public Ownership create(@RequestBody Ownership ownership){
        return ownershipService.save(ownership);
    }

    @Secured({"ROLE_ADMIN"})
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

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/ownership/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){

        /*TODO Update this when can delete all images */
        // For delete the only photo
        Ownership ownership = ownershipService.findById(id);
        String nameOldPhoto = ownership.getPhoto();
        if(nameOldPhoto !=null && nameOldPhoto.length() > 0){
            Path pathOldPhoto = Paths.get("uploads").resolve(nameOldPhoto).toAbsolutePath();
            File fileOldPhoto = pathOldPhoto.toFile();
            if (fileOldPhoto.exists() && fileOldPhoto.canRead()){
                fileOldPhoto.delete();
            }
        }

        ownershipService.delete(id);
    }

    // For upload the images of each Ownership
    @Secured({"ROLE_ADMIN"})
    @PostMapping("/ownership/upload")
    public ResponseEntity<?> upload(@RequestParam("file")MultipartFile file, @RequestParam("id") Long id){
        Map<String, Object> response = new HashMap<>();

        Ownership ownership = ownershipService.findById(id);

        if(!file.isEmpty()) {
            //randomUUID for give to the image a random id
            String nameFile = UUID.randomUUID().toString() + "_" + file.getOriginalFilename().replace(" ","");
            //Path complete of images on directory spring
            Path pathFile = Paths.get("uploads").resolve(nameFile).toAbsolutePath();

            try {
                Files.copy(file.getInputStream(), pathFile);
            } catch (IOException e) {
                //e.printStackTrace();
                response.put("message", "Error al subir la imagen del inmueble" + nameFile);
                response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            /*TODO Delete this when can upload multiple images */
            // For delete the old photo
            String nameOldPhoto = ownership.getPhoto();
            if(nameOldPhoto !=null && nameOldPhoto.length() > 0){
                Path pathOldPhoto = Paths.get("uploads").resolve(nameOldPhoto).toAbsolutePath();
                File fileOldPhoto = pathOldPhoto.toFile();
                if (fileOldPhoto.exists() && fileOldPhoto.canRead()){
                    fileOldPhoto.delete();
                }
            }

            ownership.setPhoto(nameFile);
            ownershipService.save(ownership);
            response.put("ownership", ownership);
            response.put("message", "Has subido correctamente la imagen: " + nameFile);

        }

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    //{namePhoto} Is used to send the PathVariable to the url
    // ":.+" is an expression used to send a extension
    // That method is used to create the urls for download the images
    @GetMapping("/uploads/img/{namePhoto:.+}")
    public ResponseEntity<Resource> showPhoto(@PathVariable String namePhoto){

        Path pathFile = Paths.get("uploads").resolve(namePhoto).toAbsolutePath();
        Resource resource = null;

        try {
            resource = new UrlResource(pathFile.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (!resource.exists() && !resource.isReadable()){
            throw new RuntimeException("No se pudo cargar la imagen: " + namePhoto);
        }
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + resource.getFilename() + "\"");

        return new ResponseEntity<Resource>(resource,header,HttpStatus.OK);
    }

}
