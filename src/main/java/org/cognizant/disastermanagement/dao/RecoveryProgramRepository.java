package org.cognizant.disastermanagement.dao;
import org.cognizant.disastermanagement.entity.RecoveryProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RecoveryProgramRepository extends JpaRepository<RecoveryProgram, Integer> {

}