package com.kafka.service;

import com.kafka.model.Employee;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final KafkaTemplate<String, Employee> kafkaTemplate;

    public EmployeeService(KafkaTemplate<String, Employee> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void setEmployee(Employee employee) {
        kafkaTemplate.send("myTopic", employee);
    }
}
