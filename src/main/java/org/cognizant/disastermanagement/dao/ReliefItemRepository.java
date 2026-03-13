package org.cognizant.disastermanagement.dao;
import org.cognizant.disastermanagement.entities.ReliefItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReliefItemRepository extends JpaRepository<ReliefItem , Integer> {
}
