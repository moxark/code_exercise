package com.code.exercise.demo.service;

import com.code.exercise.demo.dto.EmployeeDto;
import com.code.exercise.demo.entity.Employee;
import com.code.exercise.demo.mapper.EmployeeMapper;
import com.code.exercise.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    public EmployeeDto getEmployee(UUID id) {
        return employeeRepository.findById(id).map(EmployeeMapper.MAPPER::entityToDto).orElse(null);
    }

    public List<EmployeeDto> getEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeeDtos = new ArrayList<>(employees.size());
        employees.forEach(employee -> employeeDtos.add(EmployeeMapper.MAPPER.entityToDto(employee)));

        return employeeDtos;
    }

    public EmployeeDto createEmployee(EmployeeDto employeeDto){
        log.info("Create new employee " + employeeDto);
        Employee newEmployee = EmployeeMapper.MAPPER.dtoToEntity(employeeDto);
        newEmployee = employeeRepository.save(newEmployee);
        log.info("employee saved " + newEmployee);
        return EmployeeMapper.MAPPER.entityToDto(newEmployee);
    }

    public void deleteEmployee(UUID id){
        employeeRepository.deleteById(id);
    }

}
