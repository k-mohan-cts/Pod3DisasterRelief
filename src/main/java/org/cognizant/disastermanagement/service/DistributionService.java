package org.cognizant.disastermanagement.service;

import org.cognizant.disastermanagement.dao.DistributionRepository;
import org.cognizant.disastermanagement.entities.Distribution;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DistributionService {

    private final DistributionRepository distributionRepository;

    public DistributionService(DistributionRepository distributionRepository) {
        this.distributionRepository = distributionRepository;
    }

    public List<Distribution> getAllDistributions() {
        return distributionRepository.findAll();
    }

    public Distribution saveDistribution(Distribution distribution) {
        return distributionRepository.save(distribution);
    }
}