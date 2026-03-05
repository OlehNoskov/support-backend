package com.nix.education.controller;

import com.nix.education.persistence.entity.Ticket;
import com.nix.education.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@AllArgsConstructor
public class TicketController {
  private final TicketService ticketService;

  @PostMapping
  @RequestMapping("/create")
  public Ticket create(@RequestBody Ticket ticket) {
    return ticketService.createTicket(ticket);
  }

  @PutMapping
  @RequestMapping("/update/{ticketId}")
  public Ticket update(@RequestBody Ticket ticket, @PathVariable("ticketId") String ticketId) {
    return ticketService.updateTicket(ticketId, ticket);
  }

  @DeleteMapping
  @RequestMapping("/delete/{ticketId}")
  public void delete(@PathVariable("ticketId") String ticketId) {
    ticketService.deleteTicket(ticketId);
  }

  @GetMapping
  @RequestMapping("/all")
  public List<Ticket> allTickets() {
    return ticketService.getAllTickets();
  }

  @GetMapping
  @RequestMapping("/{ticketId}")
  public Ticket getTicketById(@PathVariable("ticketId") String ticketId) {
    return ticketService.getTicketById(ticketId);
  }
}
