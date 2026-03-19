package org.cognizant.disastermanagement.controller;

import org.cognizant.disastermanagement.dto.DistributionRequestDTO;
import org.cognizant.disastermanagement.dto.DistributionResponseDTO;
import org.cognizant.disastermanagement.service.DistributionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Distributions")
public class DistributionController {

    private final DistributionService distributionService;

    public DistributionController(DistributionService distributionService) {
        this.distributionService = distributionService;
    }

    // 1. GET: Fetch all distribution records as DTOs
    @GetMapping
    public ResponseEntity<List<DistributionResponseDTO>> getDistributions() {
        List<DistributionResponseDTO> responseList = distributionService.getAllDistributions();
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    // 2. POST: Create a new distribution record using RequestDTO
    @PostMapping
    public ResponseEntity<DistributionResponseDTO> createDistribution(@RequestBody DistributionRequestDTO requestDto) {
        DistributionResponseDTO response = distributionService.saveDistribution(requestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}