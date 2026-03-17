package org.cognizant.disastermanagement.controller;
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
    public List<ReliefItem> getReliefItem(){
        return reliefItemService.getAllReliefItem();
    }

    @PostMapping
    public ReliefItem createReliefItem(@RequestBody ReliefItem reliefItem){
        return reliefItemService.saveReliefItem(reliefItem);
    }


}
