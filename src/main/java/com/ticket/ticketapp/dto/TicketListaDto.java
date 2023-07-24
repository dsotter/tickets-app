package com.ticket.ticketapp.dto;


import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.List;
@Getter
@Setter
public class TicketListaDto implements Serializable {
    private static final long serialVersionUID = -4868775137443455410L;
    private List<TicketDto> ticketLista;
    private String mensaje;

}
