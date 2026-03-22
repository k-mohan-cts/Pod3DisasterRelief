package org.cognizant.disastermanagement.dao;

import org.cognizant.disastermanagement.entity.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelterRepository extends JpaRepository<Shelter, Integer> {
    // Standard CRUD operations are automatically included
    Shelter findByName(String name);
}