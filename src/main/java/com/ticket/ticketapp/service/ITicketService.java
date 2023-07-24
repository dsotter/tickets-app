package com.ticket.ticketapp.service;

import com.ticket.ticketapp.dto.TicketDto;
import com.ticket.ticketapp.dto.TicketListaDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITicketService {

    Page<TicketDto> buscarTodos(Pageable pageable);

    TicketDto buscarPorId(Long id);

    TicketDto actualizarPorId(Long id, TicketDto ticketDto);
    TicketDto borrarPorId(Long id);

    TicketDto crearTicket(TicketDto ticketDto);

}
