package org.cognizant.disastermanagement.service;
import org.cognizant.disastermanagement.dao.ReliefItemRepository;
import org.cognizant.disastermanagement.dto.ReliefItemRequestDTO;
import org.cognizant.disastermanagement.dto.ReliefItemResponseDTO;
import org.cognizant.disastermanagement.entity.ReliefItem;
import org.cognizant.disastermanagement.entity.Shelter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service

public class ReliefItemService {
    @Autowired
    private  ReliefItemRepository reliefItemsRepository;

    public ReliefItemService(ReliefItemRepository reliefItemsRepository){
        this.reliefItemsRepository = reliefItemsRepository;
    }

    public List<ReliefItemResponseDTO> getAllReliefItem(){
        return reliefItemsRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    public ReliefItemResponseDTO saveReliefItem(ReliefItemRequestDTO dto){
        ReliefItem item = new ReliefItem();
        item.setType(dto.getType());
        item.setName(dto.getName());
        item.setQuantity(dto.getQuantity());
        item.setUnit(dto.getUnit());
        item.setStatus(dto.getStatus());
        item.setCreatedAt(LocalDateTime.now());
        item.setUpdatedAt(LocalDateTime.now());

        ReliefItem saved = reliefItemsRepository.save(item);
        return mapToResponseDTO(saved);
    }

    private ReliefItemResponseDTO mapToResponseDTO(ReliefItem item) {
        ReliefItemResponseDTO resp = new ReliefItemResponseDTO();
        resp.setItemId(item.getItemId());
        resp.setType(item.getType());
        resp.setName(item.getName());
        resp.setQuantity(item.getQuantity());
        resp.setUnit(item.getUnit());
        resp.setStatus(item.getStatus());
        resp.setUpdatedAt(item.getUpdatedAt());
        return resp;
    }
    public ReliefItemResponseDTO updateReliefItem(ReliefItemRequestDTO request) {
        ReliefItem record = reliefItemsRepository.findByName(request.getName());

        if (record == null) {
            throw new RuntimeException("ReliefItem not found");
        }
        // By explicitly setting the ID, you FORCE JPA to perform an update.
        ReliefItem updatedRecord = record.toBuilder()
                .itemId(record.getItemId()) // This is the "Insurance Policy"
                .type(request.getType())
                .quantity(request.getQuantity())
                .unit(request.getUnit())
                .status(request.getStatus())
                .updatedAt(LocalDateTime.now())
                .build();

        return mapToResponseDTO(reliefItemsRepository.save(updatedRecord));
    }
}
