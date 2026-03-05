package com.nix.education.service.impl;

import com.nix.education.persistence.entity.Ticket;
import com.nix.education.persistence.repository.TicketRepository;
import com.nix.education.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {
  private final TicketRepository ticketRepository;

  @Override
  public Ticket createTicket(Ticket ticket) {
    ticket.setCreatedDate(new Date());
    return ticketRepository.save(ticket);
  }

  @Override
  public Ticket updateTicket(String id, Ticket ticket) {
    Ticket existingTicket = ticketRepository.findById(id).orElse(null);
    if (existingTicket != null) {
      existingTicket.setTitle(ticket.getTitle());
      existingTicket.setDescription(ticket.getDescription());
      existingTicket.setAssignee(ticket.getAssignee());
      existingTicket.setReporter(ticket.getReporter());
      existingTicket.setCreatedDate(ticket.getCreatedDate());
      existingTicket.setLastUpdatedDate(ticket.getLastUpdatedDate());
      existingTicket.setStatus(ticket.getStatus());
      existingTicket.setComments(ticket.getComments());
      existingTicket.setLogs(ticket.getLogs());
      existingTicket.setLastUpdatedDate(new Date());
      return ticketRepository.save(existingTicket);
    }
    return null;
  }

  @Override
  public void deleteTicket(String id) {
    ticketRepository.deleteById(id);
  }

  @Override
  public List<Ticket> getAllTickets() {
    return ticketRepository.findAll();
  }

  @Override
  public Ticket getTicketById(String id) {
    return ticketRepository.findById(id).orElse(Ticket.builder().build());
  }
}
