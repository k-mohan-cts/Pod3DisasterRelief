package org.cognizant.disastermanagement.dao;
import org.cognizant.disastermanagement.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {
    List<Resource> findByRecoveryProgramProgramId(int programId);
}