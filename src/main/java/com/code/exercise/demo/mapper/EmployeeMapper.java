package com.code.exercise.demo.mapper;

import com.code.exercise.demo.dto.EmployeeDto;
import com.code.exercise.demo.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface EmployeeMapper extends Converter<EmployeeDto,Employee> {

    EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);

    Employee dtoToEntity(EmployeeDto employeeDto);
    EmployeeDto entityToDto(Employee employee);
}
