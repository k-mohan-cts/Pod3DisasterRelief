package org.cognizant.disastermanagement.dao;
import org.cognizant.disastermanagement.entity.ReliefItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReliefItemRepository extends JpaRepository<ReliefItem , Integer> {

    ReliefItem findByName(String name);
}
