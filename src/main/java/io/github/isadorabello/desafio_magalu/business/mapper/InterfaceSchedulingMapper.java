package io.github.isadorabello.desafio_magalu.business.mapper;

import io.github.isadorabello.desafio_magalu.controller.dto.SchedulingRequestDTO;
import io.github.isadorabello.desafio_magalu.controller.dto.SchedulingResponseDTO;
import io.github.isadorabello.desafio_magalu.infrastructure.entity.Scheduling;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Bean;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface InterfaceSchedulingMapper {


    Scheduling toEntity (SchedulingRequestDTO dto);

    SchedulingResponseDTO toResponseDTO(Scheduling scheduling);

    @Mapping(target = "dataHoraModificacao", expression = "java(LocalDateTime.now())")
    @Mapping(target = "status", expression = "java(StatusNotificacaoEnum.CANCELADO)")
    Scheduling toCancelEntity (Scheduling scheduling);

}
