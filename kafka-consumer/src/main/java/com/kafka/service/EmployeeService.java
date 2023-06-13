package com.kafka.service;

import com.kafka.model.Employee;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class EmployeeService {

    @KafkaListener(topics = "myTopic", groupId = "myGroup")
    public void consumeEmployee(Employee employee) {
        log.info(employee);
    }

}
