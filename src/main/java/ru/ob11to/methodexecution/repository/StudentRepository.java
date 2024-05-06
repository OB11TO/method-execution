package ru.ob11to.methodexecution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ob11to.methodexecution.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
