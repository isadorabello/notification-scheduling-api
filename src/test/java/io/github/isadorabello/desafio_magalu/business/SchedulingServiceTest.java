package io.github.isadorabello.desafio_magalu.business;


import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.isadorabello.desafio_magalu.business.mapper.InterfaceSchedulingMapper;
import io.github.isadorabello.desafio_magalu.controller.dto.SchedulingRequestDTO;
import io.github.isadorabello.desafio_magalu.controller.dto.SchedulingResponseDTO;
import io.github.isadorabello.desafio_magalu.infrastructure.entity.Scheduling;
import io.github.isadorabello.desafio_magalu.infrastructure.enums.StatusNotificacaoEnum;
import io.github.isadorabello.desafio_magalu.infrastructure.repository.SchedulingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SchedulingServiceTest {

    @InjectMocks
    private SchedulingService service;

    @Mock
    private SchedulingRepository repository;

    @Mock
    private InterfaceSchedulingMapper mapper;

    private SchedulingRequestDTO request;
    private SchedulingResponseDTO response;
    private Scheduling scheduling;

    @BeforeEach
    void setUp() {

        // Crie uma entidade de exemplo. Caso utilize record ou classe, adapte conforme necessário.
        scheduling = Scheduling.builder()
                .id(1L)
                .dataHotaEnvio( LocalDateTime.of(2025, 1, 2, 11, 1, 1))
                .emailDestinatario("email@email.com")
                .telefoneDestinatario("55887996578")
                .mensagem("Favor retornar a loja com urgência")
                .dataHoraAgendamento(LocalDateTime.now())
                .build();

        // Dados de entrada
        request = new SchedulingRequestDTO("email@email.com", "0123456789",
                "Favor retornar a loja!", LocalDateTime.of(2025, 1, 2, 11, 1, 1));

        // Resultado esperado
        response = new SchedulingResponseDTO(1L, "email@email.com", "0123456789",
                "Favor retornar a loja!", LocalDateTime.of(2025, 1, 2, 11, 1, 1), StatusNotificacaoEnum.AGENDADO);
    }

    @Test
    void createScheduling(){

        // Define o comportamento do mapper: mapeia o DTO para a entidade
        when(mapper.toEntity(request)).thenReturn(scheduling);
        // Simula a operação de salvar a entidade no repositório
        when(repository.save(scheduling)).thenReturn(scheduling);
        // Mapeia a entidade salva para o DTO de saída
        when(mapper.toResponseDTO(scheduling)).thenReturn(response);

        // Chama o método a ser testado
        SchedulingResponseDTO dto = service.salvarAgendamento(request);

        // Verifica se o resultado é o esperado
        assertEquals(response, dto, "O objeto retornado deve ser igual ao esperado");

    }

}
