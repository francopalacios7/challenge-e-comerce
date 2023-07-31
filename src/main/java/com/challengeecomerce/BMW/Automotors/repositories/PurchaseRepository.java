package com.challengeecomerce.BMW.Automotors.repositories;

import com.challengeecomerce.BMW.Automotors.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PurchaseRepository extends JpaRepository<Purchase,Long> {
    Purchase findByTicketNumber(Long ticketNumber);
}
