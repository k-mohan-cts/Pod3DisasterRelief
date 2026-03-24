package org.cognizant.disastermanagement.controller;

import org.cognizant.disastermanagement.dto.request.CitizenRequestDTO;
import org.cognizant.disastermanagement.entity.Citizen;
import org.cognizant.disastermanagement.entity.User;
import org.cognizant.disastermanagement.service.CitizenService;
import org.cognizant.disastermanagement.service.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/citizens")
public class CitizenController {

    @Autowired
    private CitizenService citizenService;

    @Autowired
    private UserService userService;

    // ✅ CREATE CITIZEN WITH VALIDATION
    @PostMapping("/createCitizen")
    public Citizen createCitizen(@Valid @RequestBody CitizenRequestDTO requestDTO) {

        User user = userService.getUserById(requestDTO.getUserId());

        Citizen citizen = new Citizen();
        citizen.setName(requestDTO.getName());
        citizen.setDob(requestDTO.getDob());
        citizen.setGender(requestDTO.getGender());
        citizen.setAddress(requestDTO.getAddress());
        citizen.setContactInfo(requestDTO.getContactInfo());
        citizen.setStatus(requestDTO.getStatus());
        citizen.setUser(user);

        return citizenService.createCitizen(citizen);
    }

    @GetMapping("/getCitizenById/{id}")
    public Citizen getCitizenById(@PathVariable int id) {
        return citizenService.getCitizenById(id);
    }

    // ✅ UPDATE WITH VALIDATION
    @PutMapping("/update/{id}")
    public Citizen updateCitizen(
            @PathVariable int id,
            @Valid @RequestBody CitizenRequestDTO requestDTO) {

        User user = userService.getUserById(requestDTO.getUserId());

        Citizen citizen = new Citizen();
        citizen.setCitizenId(id);
        citizen.setName(requestDTO.getName());
        citizen.setDob(requestDTO.getDob());
        citizen.setGender(requestDTO.getGender());
        citizen.setAddress(requestDTO.getAddress());
        citizen.setContactInfo(requestDTO.getContactInfo());
        citizen.setStatus(requestDTO.getStatus());
        citizen.setUser(user);

        return citizenService.updateCitizen(id, citizen);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCitizen(@PathVariable int id) {
        citizenService.deleteCitizen(id);
    }
}