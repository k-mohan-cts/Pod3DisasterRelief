package org.cognizant.disastermanagement.service;

import org.cognizant.disastermanagement.dao.ShelterRepository;
import org.cognizant.disastermanagement.dto.request.ShelterRequestDTO;
import org.cognizant.disastermanagement.dto.response.ShelterResponseDTO;
import org.cognizant.disastermanagement.entity.Shelter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShelterService {

    @Autowired
    private ShelterRepository shelterRepository;

    // 1. Save a new shelter using RequestDTO
    public ShelterResponseDTO addShelter(ShelterRequestDTO dto) {
        // Map DTO to Entity (Matching your Capitalized Entity fields)
        Shelter shelter = new Shelter();
        shelter.setName(dto.getName());
        shelter.setLocation(dto.getLocation());
        shelter.setLatitude(dto.getLatitude());
        shelter.setLongitude(dto.getLongitude());
        shelter.setCapacity(dto.getCapacity());
        shelter.setOccupancy(dto.getOccupancy());
        shelter.setStatus(dto.getStatus());
        shelter.setContactInfo(dto.getContactInfo());

        // Handle the timestamps that were "missing" from the DTO
        shelter.setCreatedAt(LocalDateTime.now());
        shelter.setUpdatedAt(LocalDateTime.now());

        // Save Entity to DB
        Shelter savedShelter = shelterRepository.save(shelter);

        // Convert saved Entity back to ResponseDTO
        return mapToResponseDTO(savedShelter);
    }

    // 2. Get all shelters converted to ResponseDTOs
    public List<ShelterResponseDTO> getAllShelters() {
        List<Shelter> shelters = shelterRepository.findAll();

        // Convert the list of Entities to a list of DTOs
        return shelters.stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    // Helper Method: Map Entity -> ResponseDTO
    private ShelterResponseDTO mapToResponseDTO(Shelter shelter) {
        ShelterResponseDTO response = new ShelterResponseDTO();

        response.setShelterId(shelter.getShelterId());
        response.setName(shelter.getName());
        response.setLocation(shelter.getLocation());
        response.setStatus(shelter.getStatus());
        response.setContactInfo(shelter.getContactInfo());
        response.setCapacity(shelter.getCapacity());
        response.setOccupancy(shelter.getOccupancy());

        // Logical Calculation: Capacity - Occupancy

        response.setUpdatedAt(shelter.getUpdatedAt());

        return response;
    }


    public ShelterResponseDTO updateShelters(ShelterRequestDTO request) {
        Shelter record = shelterRepository.findByName(request.getName());

        if (record == null) {
            throw new RuntimeException("Shelter not found");
        }
        Shelter updatedRecord = record.toBuilder()
                .capacity(request.getCapacity())
                .contactInfo(request.getContactInfo())
                .location(request.getLocation())
                .occupancy(request.getOccupancy())
                .status(request.getStatus())
                .build();
        Shelter savedRecord = shelterRepository.save(updatedRecord);
        return mapToResponseDTO(savedRecord);
    }

}