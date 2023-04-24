package com.project.tta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.tta.service.TicketService;
import com.project.tta.entity.*;


@Controller

public class TicketController {


    private TicketService ticketService;


    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
   
    @GetMapping("/tickets")
    public String listTickets(Model model) {
        model.addAttribute("tickets", ticketService.getAllTickets());
        return "tickets";
    }  
    
    @GetMapping("/tickets/new")
   public String createTicketForm(Model model) {
    	
    	
      
    	
       Ticket ticket = new Ticket();
       model.addAttribute("ticket", ticket);
       return "create_ticket";
   }


   @PostMapping("/tickets")
   public String saveTicket(
           @ModelAttribute("ticket") Ticket ticket) {
       ticketService.saveTicket(ticket);
       return "redirect:/tickets";
   }  
   
   @GetMapping("/tickets/edit/{id}")
	public String editTicketForm(@PathVariable Long id, Model model) {
		model.addAttribute("ticket", ticketService.getTicketById(id));
		return "edit_ticket";
	}
   
   @PostMapping("/tickets/{id}")
	public String updateTicket(
			
			@PathVariable Long id, 
			@ModelAttribute("ticket") 
			Ticket ticket, Model model) {

	
	   
		Ticket existingTicket = ticketService.getTicketById(id);
		existingTicket.setId(id);
		existingTicket.setTitle(ticket.getTitle());
		existingTicket.setDescription(ticket.getDescription());
		existingTicket.setCreateon(ticket.getCreateon());

	
		
		ticketService.updateTicket(existingTicket);
		return "redirect:/tickets";
	}	

   
   @GetMapping("/tickets/{id}")
   public String deleteTicket(@PathVariable Long id) {
       ticketService.deleteTicketById(id);
       return "redirect:/tickets";
   }

   

   
   
	
}
