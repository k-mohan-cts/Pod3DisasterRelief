package org.cognizant.disastermanagement.controller;

import org.cognizant.disastermanagement.entity.Shelter;
import org.cognizant.disastermanagement.service.ShelterService; // Adjust package as needed
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Shelters") // Match the URL you'll use in Postman
public class ShelterController {

    @Autowired
    private ShelterService shelterService;

    // GET: http://localhost:1234/Shelters
    @GetMapping
    public List<Shelter> getShelters() {
        return shelterService.getAllShelters();
    }

    // POST: http://localhost:1234/Shelters
    @PostMapping
    public Shelter createShelter(@RequestBody Shelter shelter) {
        return shelterService.addShelter(shelter);
    }
}