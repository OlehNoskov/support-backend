package com.nix.education.service;

import com.nix.education.persistence.entity.Ticket;

import java.util.List;

public interface TicketService {
  Ticket createTicket(Ticket ticket);
  Ticket updateTicket(String id, Ticket ticket);
  void deleteTicket(String id);
  List<Ticket> getAllTickets();
  Ticket getTicketById(String id);
}
