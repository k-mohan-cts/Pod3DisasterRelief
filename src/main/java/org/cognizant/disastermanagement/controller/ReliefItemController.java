package org.cognizant.disastermanagement.controller;
import org.cognizant.disastermanagement.dto.ReliefItemRequestDTO;
import org.cognizant.disastermanagement.dto.ReliefItemResponseDTO;
import org.cognizant.disastermanagement.entity.ReliefItem;
import org.cognizant.disastermanagement.service.ReliefItemService;
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
    public ReliefItemResponseDTO createReliefItem(@RequestBody ReliefItemRequestDTO reliefItemDto){
        return reliefItemService.saveReliefItem(reliefItemDto);
    }
    @PutMapping ReliefItemResponseDTO updateReleifItem(@RequestBody ReliefItemRequestDTO reliefItemDto){
        return reliefItemService.updateReliefItem(reliefItemDto);
    }
}
