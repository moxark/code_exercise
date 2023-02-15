package com.code.exercise.demo.controller;

import com.code.exercise.demo.dto.EmployeeDto;
import com.code.exercise.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/employee")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable UUID id){
        EmployeeDto employeeDto = employeeService.getEmployee(id);
        if(employeeDto == null){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(employeeDto);
        }
    }

    @GetMapping("")
    public List<EmployeeDto> getEmployees(){
        return employeeService.getEmployees();
    }

    @PostMapping("")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.createEmployee(employeeDto);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable UUID id){
        employeeService.deleteEmployee(id);
    }
}
