package com.challengeecomerce.BMW.Automotors.repositories;

import com.challengeecomerce.BMW.Automotors.models.ModType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ModTypeRepository extends JpaRepository<ModType, Long> {
    ModType findByName(String name);
}
