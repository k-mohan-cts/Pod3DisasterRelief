package org.cognizant.disastermanagement.service;
import org.cognizant.disastermanagement.dao.ReliefItemRepository;
import org.cognizant.disastermanagement.dto.ReliefItemRequestDTO;
import org.cognizant.disastermanagement.dto.ReliefItemResponseDTO;
import org.cognizant.disastermanagement.entity.ReliefItem;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReliefItemService {

    private final ReliefItemRepository reliefItemsRepository;

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
}
