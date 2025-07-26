package io.github.isadorabello.desafio_magalu.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.isadorabello.desafio_magalu.infrastructure.enums.StatusNotificacaoEnum;

import java.time.LocalDateTime;

public record SchedulingResponseDTO(Long id,
                                    String emailDestinatario,
                                    String telefoneDestinatario,
                                    String mensagem,
                                    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
                                    LocalDateTime dataHoraEnvio,
                                    StatusNotificacaoEnum status) {
}
