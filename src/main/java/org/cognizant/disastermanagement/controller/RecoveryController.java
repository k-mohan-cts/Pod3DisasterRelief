package org.cognizant.disastermanagement.controller;

import jakarta.validation.Valid;
import org.cognizant.disastermanagement.dto.RecoveryProgramDTO;
import org.cognizant.disastermanagement.dto.ResourceDTO;
import org.cognizant.disastermanagement.entity.RecoveryProgram;
import org.cognizant.disastermanagement.service.RecoveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/programs")
public class RecoveryController {

    @Autowired
    private RecoveryService recoveryService;

    @PostMapping("/create")
    public ResponseEntity<String> createProgram(@Valid @RequestBody RecoveryProgramDTO dto) {
        RecoveryProgram entity = toEntity(dto);
        recoveryService.createProgram(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body("Recovery Program created successfully");
    }

    @GetMapping("/viewAll")
    public ResponseEntity<List<RecoveryProgramDTO>> getAllPrograms() {
        List<RecoveryProgramDTO> list = recoveryService.getAllPrograms()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<RecoveryProgramDTO> getProgramById(@PathVariable int id) {
        RecoveryProgram program = recoveryService.getProgramById(id);
        return ResponseEntity.ok(toDTO(program));
    }

    private RecoveryProgramDTO toDTO(RecoveryProgram entity) {
        RecoveryProgramDTO dto = new RecoveryProgramDTO();
        dto.setProgramId(entity.getProgramId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        dto.setBudget(entity.getBudget());
        dto.setStatus(entity.getStatus());

        if (entity.getResources() != null) {
            dto.setResources(entity.getResources().stream().map(res -> {
                ResourceDTO rDto = new ResourceDTO();
                rDto.setResourceId(res.getResourceId());
                rDto.setName(res.getName());
                rDto.setType(res.getType());
                rDto.setQuantity(res.getQuantity());
                rDto.setUnit(res.getUnit());
                rDto.setStatus(res.getStatus());
                return rDto;
            }).collect(Collectors.toList()));
        }
        return dto;
    }

    private RecoveryProgram toEntity(RecoveryProgramDTO dto) {
        RecoveryProgram entity = new RecoveryProgram();
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setBudget(dto.getBudget());
        entity.setStatus(dto.getStatus()); // Fixed: Mapping status
        // If your DTO has a managerId, set it here; otherwise, default to a system ID
        //entity.setManagerId(dto.);
        return entity;
    }
}