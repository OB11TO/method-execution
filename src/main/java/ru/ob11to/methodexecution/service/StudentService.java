package ru.ob11to.methodexecution.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ob11to.methodexecution.dto.StudentCreateDto;
import ru.ob11to.methodexecution.dto.StudentReadDto;
import ru.ob11to.methodexecution.entity.Student;
import ru.ob11to.methodexecution.mapper.StudentMapper;
import ru.ob11to.methodexecution.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Transactional
    public Optional<StudentReadDto> findById(Long id) {
        log.info("Get student with id : {}", id);
        return studentRepository.findById(id)
                .map(studentMapper::toDto);
    }

    @Transactional
    public List<StudentReadDto> findAll() {
        log.info("Get all students");
        return studentRepository.findAll().stream()
                .map(studentMapper::toDto)
                .collect(toList());
    }

    @Transactional
    public StudentReadDto createStudent(StudentCreateDto studentCreateDto) {
        log.info("Create student : {}", studentCreateDto);
        return Optional.of(studentCreateDto)
                .map(studentMapper::toEntity)
                .map(studentRepository::save)
                .map(studentMapper::toDto)
                .orElseThrow();
    }

    @Transactional
    public Optional<StudentReadDto> updateStudent(Long id, StudentCreateDto studentCreateDto) {
        log.info("Update student with id : {}, data : {}", id, studentCreateDto);
        return studentRepository.findById(id)
                .map(entity -> studentMapper.toEntity(studentCreateDto))
                .map(studentRepository::saveAndFlush)
                .map(studentMapper::toDto);
    }


    @Transactional
    public boolean deleteStudent(Long id) {
        log.info("Remove student with id : {}", id);
        return studentRepository.findById(id)
                .map(entity -> {
                    studentRepository.delete(entity);
                    studentRepository.flush();
                    return true;
                })
                .orElse(false);
    }

}