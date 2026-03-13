package org.cognizant.disastermanagement.service;
import org.cognizant.disastermanagement.dao.ReliefItemRepository;
import org.cognizant.disastermanagement.entities.ReliefItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReliefItemService {

    private final ReliefItemRepository reliefItemsRepository;

    public ReliefItemService(ReliefItemRepository reliefItemsRepository){
        this.reliefItemsRepository = reliefItemsRepository;
    }

    public List<ReliefItem> getAllReliefItem(){
        return reliefItemsRepository.findAll();
    }

    public ReliefItem saveReliefItem(ReliefItem reliefItem){
        return reliefItemsRepository.save(reliefItem);
    }
}
