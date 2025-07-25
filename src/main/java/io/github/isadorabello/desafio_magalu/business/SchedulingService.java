package io.github.isadorabello.desafio_magalu.business;

import io.github.isadorabello.desafio_magalu.business.mapper.InterfaceSchedulingMapper;
import io.github.isadorabello.desafio_magalu.controller.dto.SchedulingRequestDTO;
import io.github.isadorabello.desafio_magalu.controller.dto.SchedulingResponseDTO;
import io.github.isadorabello.desafio_magalu.infrastructure.exception.NotFoundException;
import io.github.isadorabello.desafio_magalu.infrastructure.repository.SchedulingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchedulingService {

    private final SchedulingRepository repository;
    private final InterfaceSchedulingMapper mapper;

    public SchedulingResponseDTO salvarAgendamento(SchedulingRequestDTO dto){
        return mapper.toResponseDTO(repository.save(mapper.toEntity(dto)));
    }

    public SchedulingResponseDTO buscarAgendamento (Long id){
        return mapper.toResponseDTO(repository.findById(id).orElseThrow(() -> new NotFoundException("Usuário com o ID informado não foi encontrado")));
    }

}
