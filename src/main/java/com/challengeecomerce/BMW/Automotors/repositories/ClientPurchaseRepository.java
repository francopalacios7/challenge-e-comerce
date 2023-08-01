package com.challengeecomerce.BMW.Automotors.repositories;

import com.challengeecomerce.BMW.Automotors.models.ClientPurchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientPurchaseRepository extends JpaRepository <ClientPurchase, Long> {
}
