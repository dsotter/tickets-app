package com.ticket.ticketapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
public class TicketDto implements Serializable {
    private static final long serialVersionUID = -4868775137443455410L;

    private Long id;
    private String usuario;
    private Date fechaCreacion;
    private Date fechaActualizacion;
    private String estatus;
    private String mensaje;

}
