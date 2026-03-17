package org.cognizant.disastermanagement.dao;

import org.cognizant.disastermanagement.entity.Distribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributionRepository extends JpaRepository<Distribution, Integer> {

}