package io.github.isadorabello.desafio_magalu.controller;

import io.github.isadorabello.desafio_magalu.business.SchedulingService;
import io.github.isadorabello.desafio_magalu.controller.dto.SchedulingRequestDTO;
import io.github.isadorabello.desafio_magalu.controller.dto.SchedulingResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/scheduling")
public class SchedulingController {

    private final SchedulingService service;

    @PostMapping
    public ResponseEntity<SchedulingResponseDTO> salvarAgendamento(@RequestBody SchedulingRequestDTO dto){

        // MINHA RESPOSTA:
        // SchedulingResponseDTO response = service.salvarAgendamento(dto);
        // return new ResponseEntity<SchedulingResponseDTO>(response, HttpStatus.OK);

        return ResponseEntity.ok(service.salvarAgendamento(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchedulingResponseDTO> buscarAgendamentoPorID(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.buscarAgendamento(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarAgendamento(@PathVariable("id") Long id){
        service.cancelarAgendamento(id);
        return ResponseEntity.accepted().build();
    }

}
