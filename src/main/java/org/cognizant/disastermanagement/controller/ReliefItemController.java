package org.cognizant.disastermanagement.controller;
import org.cognizant.disastermanagement.dao.DistributionRepository;
import org.cognizant.disastermanagement.dao.ReliefItemRepository;
import org.cognizant.disastermanagement.dto.request.ReliefItemRequestDTO;
import org.cognizant.disastermanagement.dto.response.ReliefItemResponseDTO;
import org.cognizant.disastermanagement.service.ReliefItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/ReliefItems")
public class ReliefItemController {

    private final ReliefItemService reliefItemService;


    public ReliefItemController(ReliefItemService reliefItemService){
        this.reliefItemService = reliefItemService;
    }

    @GetMapping
    public List<ReliefItemResponseDTO> getReliefItem(){
        return reliefItemService.getAllReliefItem();
    }

    @PostMapping
    public ResponseEntity<ReliefItemResponseDTO> createReliefItem(@RequestBody ReliefItemRequestDTO reliefItemDto){
        return ResponseEntity.ok(reliefItemService.saveReliefItem(reliefItemDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReliefItemResponseDTO> updateReliefItem(
            @PathVariable Integer id,
            @RequestBody ReliefItemRequestDTO reliefItemDto
    ) {
        // Force the ID from the URL into the DTO
        reliefItemDto.setItemId(id);

        ReliefItemResponseDTO response = reliefItemService.updateReliefItem(reliefItemDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        try {
            reliefItemService.deleteReliefItem(id);
            return ResponseEntity.ok("Relief Item with ID " + id + " deleted successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}