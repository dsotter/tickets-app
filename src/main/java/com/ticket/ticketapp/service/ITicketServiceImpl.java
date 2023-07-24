package com.ticket.ticketapp.service;

import com.ticket.ticketapp.dto.TicketDto;
import com.ticket.ticketapp.entities.Ticket;
import com.ticket.ticketapp.repository.TicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ITicketServiceImpl implements ITicketService{

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<TicketDto> buscarTodos(Pageable pageable) {

        Page<Ticket> ticketModels =  this.ticketRepository.findAll(pageable);

        return ticketModels.map(ticket -> modelMapper.map(ticket, TicketDto.class));
    }

    @Override
    public TicketDto buscarPorId(Long id) {

        Ticket ticketModel =  this.ticketRepository.findById(id).orElse(null);

        if(ticketModel == null){
            TicketDto ticketDto = new TicketDto();
            ticketDto.setMensaje("No fue encontrado este ticket.");
            return ticketDto;
        } else {
            TicketDto ticketDtoEncontrado = modelMapper.map(ticketModel, TicketDto.class);
            ticketDtoEncontrado.setMensaje("OK");
            return ticketDtoEncontrado;
        }

    }

    @Override
    public TicketDto actualizarPorId(Long id, TicketDto ticketDto) {
        Ticket ticketModel =  this.ticketRepository.findById(id).orElse(null);

        if(ticketModel == null){
            TicketDto newTicketDto = new TicketDto();
            newTicketDto.setMensaje("No fue encontrado este ticket.");
            return newTicketDto;
        } else {
            ticketModel.setUsuario(ticketDto.getUsuario());
            ticketModel.setEstatus(ticketDto.getEstatus());
            ticketModel.setFechaActualizacion(new Date());
            ticketRepository.save(ticketModel);

            TicketDto ticketDtoActualizado = modelMapper.map(ticketModel, TicketDto.class);
            ticketDtoActualizado.setMensaje("OK");
            return ticketDtoActualizado;
        }
    }

    public TicketDto borrarPorId(Long id){
        if(this.ticketRepository.existsById(id)){
            ticketRepository.deleteById(id);
            TicketDto newTicketDto = new TicketDto();
            newTicketDto.setMensaje("Ticket eliminado con éxito.");
            return newTicketDto;
        } else{
            TicketDto newTicketDto = new TicketDto();
            newTicketDto.setMensaje("Ticket no encontrado para eliminar.");
            return newTicketDto;
        }
    }

    @Override
    public TicketDto crearTicket(TicketDto ticketDto) {
        Ticket nuevoTicket =  new Ticket();

        nuevoTicket.setUsuario(ticketDto.getUsuario());
        nuevoTicket.setEstatus(ticketDto.getEstatus());
        nuevoTicket.setFechaCreacion(new Date());
        ticketRepository.save(nuevoTicket);

        TicketDto ticketDtoCreado = modelMapper.map(nuevoTicket, TicketDto.class);
        ticketDtoCreado.setMensaje("OK");
        return ticketDtoCreado;
    }

}
