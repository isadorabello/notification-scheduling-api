package io.github.isadorabello.desafio_magalu.infrastructure.repository;

import io.github.isadorabello.desafio_magalu.infrastructure.entity.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulingRepository extends JpaRepository<Scheduling, Long> {
}
