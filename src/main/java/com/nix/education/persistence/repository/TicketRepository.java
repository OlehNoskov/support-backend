package com.nix.education.persistence.repository;

import com.nix.education.persistence.entity.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<Ticket, String> {}
