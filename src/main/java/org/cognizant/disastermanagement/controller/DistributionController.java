package org.cognizant.disastermanagement.controller;

import org.cognizant.disastermanagement.entity.Distribution;
import org.cognizant.disastermanagement.service.DistributionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Distributions")
public class DistributionController {

    private final DistributionService distributionService;

    public DistributionController(DistributionService distributionService) {
        this.distributionService = distributionService;
    }

    @GetMapping
    public List<Distribution> getAll() {
        return distributionService.getAllDistributions();
    }

    @PostMapping
    public Distribution create(@RequestBody Distribution distribution) {
        return distributionService.saveDistribution(distribution);
    }
}