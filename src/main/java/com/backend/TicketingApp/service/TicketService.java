package com.backend.TicketingApp.service;

import com.backend.TicketingApp.entity.Ticket;
import com.backend.TicketingApp.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }
    public Ticket getTicketById(Long id){
        return ticketRepository.findById(id).orElse(null);
    }
    public Ticket createTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }
    public Ticket updateTicket(Long id,Ticket ticketDetails){
        Ticket ticket=ticketRepository.findById(id).orElse(null);
        if(ticket!=null){
            ticket.setUsername(ticketDetails.getUsername());
            ticket.setTitle(ticketDetails.getTitle());
            ticket.setStatus(ticketDetails.getStatus());
            ticket.setSource(ticketDetails.getSource());
            ticket.setRemarks(ticketDetails.getRemarks());
            ticket.setPriority(ticketDetails.getPriority());
            ticket.setDueDate(ticketDetails.getDueDate());
            return ticketRepository.save(ticket);
        }
        return null;
    }
    public void deleteTicket(Long id){
        ticketRepository.deleteById(id);
    }

}
