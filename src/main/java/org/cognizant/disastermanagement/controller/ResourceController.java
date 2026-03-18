package org.cognizant.disastermanagement.controller;

import jakarta.validation.Valid;
import org.cognizant.disastermanagement.dto.ResourceDTO;
import org.cognizant.disastermanagement.entity.Resource;
import org.cognizant.disastermanagement.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @PostMapping
    public ResponseEntity<String> addResource(@RequestParam("programId") int programId, @Valid @RequestBody ResourceDTO dto) {
        System.out.println(programId);
        try {
            Resource entity = toEntity(dto);
            resourceService.addResource(programId, entity);
            return ResponseEntity.status(HttpStatus.CREATED).body("Resource saved successfully.");
        } catch (RuntimeException e) {
            // This catches the "Program not found" message from your service
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }
    @GetMapping("/viewAll")
    public ResponseEntity<List<ResourceDTO>> getAllResources() {
        List<ResourceDTO> list = resourceService.getAllResources()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }
    // NEW: Logic for Program Manager to consume/use a resource

    // Mapping Methods
    private ResourceDTO toDTO(Resource entity) {
        ResourceDTO dto = new ResourceDTO();
        dto.setResourceId(entity.getResourceId());
        dto.setName(entity.getName());
        dto.setType(entity.getType());
        dto.setQuantity(entity.getQuantity());
        dto.setUnit(entity.getUnit());
        dto.setStatus(entity.getStatus());
        if (entity.getRecoveryProgram() != null) {
            dto.setProgramId(entity.getRecoveryProgram().getProgramId());
        }
        return dto;
    }

    private Resource toEntity(ResourceDTO dto) {
        Resource entity = new Resource();
        // Do NOT set ResourceID here; MySQL handles it via AUTO_INCREMENT
        entity.setName(dto.getName());
        entity.setType(dto.getType());
        entity.setQuantity(dto.getQuantity());
        entity.setUnit(dto.getUnit());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}