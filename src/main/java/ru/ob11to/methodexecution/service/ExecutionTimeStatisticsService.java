package ru.ob11to.methodexecution.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ob11to.methodexecution.dto.ExecutionTimeMethodDto;
import ru.ob11to.methodexecution.repository.ExecutionTimeMethodRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExecutionTimeStatisticsService {

    private final ExecutionTimeMethodRepository executionTimeMethodRepository;

    @Transactional
    public List<ExecutionTimeMethodDto> getAverageExecutionTimeMethods() {
        log.info("Getting average execution time methods...");
        return executionTimeMethodRepository.findAverageTimeTakenByMethodName();
    }
}
