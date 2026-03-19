package org.cognizant.disastermanagement.controller;

import org.cognizant.disastermanagement.entity.Citizen;
import org.cognizant.disastermanagement.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/citizens")
public class CitizenController {

    @Autowired
    private CitizenService citizenService;

    @PostMapping("/createCitizen")
    public Citizen createCitizen(@RequestBody Citizen citizen) {
        return citizenService.createCitizen(citizen);
    }

    @GetMapping("/getCitizenById/{id}")
    public Citizen getCitizenById(@PathVariable int id) {
        return citizenService.getCitizenById(id);
    }

    @PutMapping("/update/{id}")
    public Citizen updateCitizen(@PathVariable int id, @RequestBody Citizen citizen) {
        return citizenService.updateCitizen(id, citizen);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCitizen(@PathVariable int id) {
        citizenService.deleteCitizen(id);
    }
}