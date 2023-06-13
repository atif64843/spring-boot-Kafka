package com.kafka.Controller;

import com.kafka.model.Employee;
import com.kafka.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {


    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(path = "/employee", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> sendEmployee(@RequestBody Employee employee) {
        employeeService.setEmployee(employee);
        return new ResponseEntity<>("Added successfully", HttpStatus.CREATED);
    }
}
