package io.github.isadorabello.desafio_magalu.business;

import io.github.isadorabello.desafio_magalu.infrastructure.repository.SchedulingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchedulingService {

    private final SchedulingRepository repository;

}
