package com.backend.TicketingApp.controller;

import com.backend.TicketingApp.entity.Ticket;
import com.backend.TicketingApp.service.TicketService;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable Long id){
        return ticketService.getTicketById(id);
    }
    @PostMapping("/create")
    public Ticket createTicket(@RequestBody Ticket ticket){
        return ticketService.createTicket(ticket);
    }
    @PutMapping("/update")
    public Ticket updateTicket(@PathVariable Long id,@RequestBody Ticket ticket){
        return ticketService.updateTicket(id,ticket);
    }
    @DeleteMapping("{id}")
    public void deleteTicket(@PathVariable Long id){
        ticketService.deleteTicket(id);
    }
}

