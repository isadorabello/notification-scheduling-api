package io.github.isadorabello.desafio_magalu.business.mapper;

import io.github.isadorabello.desafio_magalu.controller.dto.SchedulingRequestDTO;
import io.github.isadorabello.desafio_magalu.controller.dto.SchedulingResponseDTO;
import io.github.isadorabello.desafio_magalu.infrastructure.entity.Scheduling;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface InterfaceSchedulingMapper {


    Scheduling toEntity (SchedulingRequestDTO dto);

    SchedulingResponseDTO toResponseDTO(Scheduling scheduling);

}
