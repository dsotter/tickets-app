package com.ticket.ticketapp.controller;

import com.ticket.ticketapp.api.ITicketApi;
import com.ticket.ticketapp.dto.TicketDto;
import com.ticket.ticketapp.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket/v1")
public class ITicketApiImplController implements ITicketApi {

    @Autowired
    private ITicketService ticketService;

    @Override
    public Page<TicketDto> obtenerTodos(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, sort.split(",")[0]));
        return ticketService.buscarTodos(pageable);
    }

    @Override
    public ResponseEntity<TicketDto> listarProductoPorId(Long id) {
        TicketDto ticketDto = ticketService.buscarPorId(id);
        return ResponseEntity.ok(ticketDto);
    }

    @Override
    public ResponseEntity<TicketDto> actualizarTicketPorId(Long id, TicketDto ticketDto) {
        TicketDto ticketDtoRespuesta = ticketService.actualizarPorId(id, ticketDto);
        return ResponseEntity.ok(ticketDtoRespuesta);
    }

    @Override
    public ResponseEntity<TicketDto> borrarPorId(Long id) {
        TicketDto ticketDto = ticketService.borrarPorId(id);
        return ResponseEntity.ok(ticketDto);
    }

    @Override
    public ResponseEntity<TicketDto> crearTicket(TicketDto requestTicketDto) {
        TicketDto ticketDtoRespuesta = ticketService.crearTicket(requestTicketDto);
        return ResponseEntity.ok(ticketDtoRespuesta);
    }
}
