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

    @PostMapping
    public Citizen createCitizen(@RequestBody Citizen citizen) {
        return citizenService.createCitizen(citizen);
    }

    @GetMapping("/{id}")
    public Citizen getCitizenById(@PathVariable int id) {
        return citizenService.getCitizenById(id);
    }

    @PutMapping("/{id}")
    public Citizen updateCitizen(@PathVariable int id, @RequestBody Citizen citizen) {
        citizen.setCitizenId(id);
        return citizenService.updateCitizen(citizen);
    }

    @DeleteMapping("/{id}")
    public void deleteCitizen(@PathVariable int id) {
        citizenService.deleteCitizen(id);
    }
}