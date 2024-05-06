package ru.ob11to.methodexecution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ob11to.methodexecution.entity.ExecutionTimeMethod;

public interface ExecutionTimeMethodRepository extends JpaRepository<ExecutionTimeMethod, Long> {
}
