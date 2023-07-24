package com.ticket.ticketapp.api;

import com.sun.istack.NotNull;
import com.ticket.ticketapp.dto.TicketDto;
import com.ticket.ticketapp.util.ConstantesApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "ITicketApi", tags = {"CRUD Tickets"})
public interface ITicketApi {

    @ApiOperation(value = "Obtener todos los tickets paginados",
            response = TicketDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201,message = ConstantesApi.API_RESPUESTA_201),
            @ApiResponse(code = 400, message = ConstantesApi.API_RESPUESTA_400),
            @ApiResponse(code = 401, message = ConstantesApi.API_RESPUESTA_401),
            @ApiResponse(code = 403, message = ConstantesApi.API_RESPUESTA_403),
            @ApiResponse(code = 404, message = ConstantesApi.API_RESPUESTA_404),
            @ApiResponse(code = 500, message = ConstantesApi.API_RESPUESTA_500)
    })
    @GetMapping("/")
    public Page<TicketDto> obtenerTodos(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "2") int size,
                                        @RequestParam(defaultValue = "id,asc") String sort);

    @ApiOperation(value = "Obtener ticket por Id", response = TicketDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201,message = ConstantesApi.API_RESPUESTA_201),
            @ApiResponse(code = 400, message = ConstantesApi.API_RESPUESTA_400),
            @ApiResponse(code = 401, message = ConstantesApi.API_RESPUESTA_401),
            @ApiResponse(code = 403, message = ConstantesApi.API_RESPUESTA_403),
            @ApiResponse(code = 404, message = ConstantesApi.API_RESPUESTA_404),
            @ApiResponse(code = 500, message = ConstantesApi.API_RESPUESTA_500)
    })
    @GetMapping(value = "/{id}", produces = {"application/json"})
    ResponseEntity<TicketDto> listarProductoPorId(@NotNull @PathVariable Long id);

    @ApiOperation(value = "Actualizar ticket por Id", response = TicketDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201,message = ConstantesApi.API_RESPUESTA_201),
            @ApiResponse(code = 400, message = ConstantesApi.API_RESPUESTA_400),
            @ApiResponse(code = 401, message = ConstantesApi.API_RESPUESTA_401),
            @ApiResponse(code = 403, message = ConstantesApi.API_RESPUESTA_403),
            @ApiResponse(code = 404, message = ConstantesApi.API_RESPUESTA_404),
            @ApiResponse(code = 500, message = ConstantesApi.API_RESPUESTA_500)
    })
    @PutMapping(value = "/{id}", consumes = {"application/json"}, produces = {"application/json"})
    ResponseEntity<TicketDto> actualizarTicketPorId(
            @NotNull @PathVariable Long id,
            @RequestBody TicketDto baseRequestDto);

    @ApiOperation(value = "Borrar ticket por Id", response = TicketDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201,message = ConstantesApi.API_RESPUESTA_201),
            @ApiResponse(code = 400, message = ConstantesApi.API_RESPUESTA_400),
            @ApiResponse(code = 401, message = ConstantesApi.API_RESPUESTA_401),
            @ApiResponse(code = 403, message = ConstantesApi.API_RESPUESTA_403),
            @ApiResponse(code = 404, message = ConstantesApi.API_RESPUESTA_404),
            @ApiResponse(code = 500, message = ConstantesApi.API_RESPUESTA_500)
    })
    @DeleteMapping(value = "/{id}", produces = {"application/json"})
    ResponseEntity<TicketDto> borrarPorId(@NotNull @PathVariable Long id);

    @ApiOperation(value = "Crear nuevo ticket", response = TicketDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201,message = ConstantesApi.API_RESPUESTA_201),
            @ApiResponse(code = 400, message = ConstantesApi.API_RESPUESTA_400),
            @ApiResponse(code = 401, message = ConstantesApi.API_RESPUESTA_401),
            @ApiResponse(code = 403, message = ConstantesApi.API_RESPUESTA_403),
            @ApiResponse(code = 404, message = ConstantesApi.API_RESPUESTA_404),
            @ApiResponse(code = 500, message = ConstantesApi.API_RESPUESTA_500)
    })
    @PostMapping(consumes = {"application/json"}, produces = {"application/json"})
    ResponseEntity<TicketDto> crearTicket(@RequestBody TicketDto requestTicketDto);

}
