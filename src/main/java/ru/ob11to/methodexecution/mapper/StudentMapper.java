package ru.ob11to.methodexecution.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.ob11to.methodexecution.dto.StudentCreateDto;
import ru.ob11to.methodexecution.dto.StudentReadDto;
import ru.ob11to.methodexecution.entity.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "address", source = "address"),
    })
    StudentReadDto toDto(Student student);

    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "address", source = "address"),
    })
    Student toEntity(StudentCreateDto studentCreateDto);
}
