package com.challengeecomerce.BMW.Automotors.repositories;

import com.challengeecomerce.BMW.Automotors.models.Mod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ModRepository extends JpaRepository <Mod, Long> {
}
