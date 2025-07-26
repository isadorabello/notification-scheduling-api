package io.github.isadorabello.desafio_magalu.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.isadorabello.desafio_magalu.business.SchedulingService;
import io.github.isadorabello.desafio_magalu.controller.dto.SchedulingRequestDTO;
import io.github.isadorabello.desafio_magalu.controller.dto.SchedulingResponseDTO;
import io.github.isadorabello.desafio_magalu.infrastructure.enums.StatusNotificacaoEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class SchedulingControllerTest {

    @InjectMocks // classe que ta sendo mockada/testada
    SchedulingController controller;

    @Mock
    SchedulingService service;

    private MockMvc mvc;
    private ObjectMapper mapper = new ObjectMapper();

    private SchedulingRequestDTO request;
    private SchedulingResponseDTO response;

    @BeforeEach
    void setUp() {

        mvc = MockMvcBuilders.standaloneSetup(controller).build();

        mapper.registerModule(new JavaTimeModule());

        request = new SchedulingRequestDTO("email@email.com", "0123456789",
                "Favor retornar a loja!", LocalDateTime.of(2025, 1, 2, 11, 1, 1));

        response = new SchedulingResponseDTO(1L, "email@email.com", "0123456789",
                "Favor retornar a loja!", LocalDateTime.of(2025, 1, 2, 11, 1, 1), StatusNotificacaoEnum.AGENDADO);
    }


    @Test
    void createScheduledSuccessfully() throws Exception{

        when(service.salvarAgendamento(request)).thenReturn(response);

        mvc.perform(post("/scheduling")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsBytes(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(response.id()))
                .andExpect(jsonPath("$.emailDestinatario").value(response.emailDestinatario()))
                .andExpect(jsonPath("$.telefoneDestinatario").value(response.telefoneDestinatario()))
                .andExpect(jsonPath("$.mensagem").value(response.mensagem()))
                .andExpect(jsonPath("$.dataHoraEnvio").value("02-01-2025 11:01:01"))
                .andExpect(jsonPath("$.status").value("AGENDADO"));


        verify(service, times(1)).salvarAgendamento(request);

    }

}
