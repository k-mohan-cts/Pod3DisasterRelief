package org.cognizant.disastermanagement.service;

import org.cognizant.disastermanagement.dao.DistributionRepository;
import org.cognizant.disastermanagement.dto.DistributionRequestDTO;
import org.cognizant.disastermanagement.dto.DistributionResponseDTO;
import org.cognizant.disastermanagement.entity.Distribution;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DistributionService {

    private final DistributionRepository distributionRepository;

    public DistributionService(DistributionRepository distributionRepository) {
        this.distributionRepository = distributionRepository;
    }

    public List<DistributionResponseDTO> getAllDistributions() {
        return distributionRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    public DistributionResponseDTO saveDistribution(DistributionRequestDTO dto) {
        Distribution distribution = new Distribution();
        distribution.setItemId(dto.getItemId());
        distribution.setCitizenId(dto.getCitizenId());
        distribution.setOfficerId(dto.getOfficerId());
        distribution.setQuantity(dto.getQuantity());
        distribution.setNotes(dto.getNotes());
        distribution.setStatus(dto.getStatus());

        // Automating the date
        distribution.setDate(LocalDateTime.now());

        Distribution saved = distributionRepository.save(distribution);
        return mapToResponseDTO(saved);
    }

    private DistributionResponseDTO mapToResponseDTO(Distribution distribution) {
        DistributionResponseDTO resp = new DistributionResponseDTO();
        resp.setDistributionId(distribution.getDistributionId());
        resp.setItemId(distribution.getItemId());
        resp.setQuantity(distribution.getQuantity());
        resp.setStatus(distribution.getStatus());
        resp.setDate(distribution.getDate());
        resp.setNotes(distribution.getNotes());
        return resp;
    }
}