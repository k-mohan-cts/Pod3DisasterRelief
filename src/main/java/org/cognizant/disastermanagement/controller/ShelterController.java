package org.cognizant.disastermanagement.controller;

import org.cognizant.disastermanagement.dto.ShelterRequestDTO;
import org.cognizant.disastermanagement.dto.ShelterResponseDTO;
import org.cognizant.disastermanagement.service.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Shelters")
public class ShelterController {

    @Autowired
    private ShelterService shelterService;

    // 1. GET: http://localhost:1234/Shelters
    // Now returns a List of ResponseDTOs instead of Entities
    @GetMapping
    public ResponseEntity<List<ShelterResponseDTO>> getShelters() {
        List<ShelterResponseDTO> responseList = shelterService.getAllShelters();
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    // 2. POST: http://localhost:1234/Shelters
    // Receives RequestDTO and returns ResponseDTO
    @PostMapping
    public ResponseEntity<ShelterResponseDTO> createShelter(@RequestBody ShelterRequestDTO requestDto) {
        ShelterResponseDTO response = shelterService.addShelter(requestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}