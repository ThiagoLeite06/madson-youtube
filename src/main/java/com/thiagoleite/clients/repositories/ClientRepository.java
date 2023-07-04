package com.thiagoleite.clients.repositories;

import com.thiagoleite.clients.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
