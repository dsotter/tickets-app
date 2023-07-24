package com.ticket.ticketapp.repository;

import com.ticket.ticketapp.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Override
    Optional<Ticket> findById(Long id);

    @Override
    List<Ticket> findAll();
}
