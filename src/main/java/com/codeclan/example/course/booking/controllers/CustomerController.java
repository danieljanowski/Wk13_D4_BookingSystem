package com.codeclan.example.course.booking.controllers;

import com.codeclan.example.course.booking.models.Customer;
import com.codeclan.example.course.booking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(name = "course", required = false) String course,
            @RequestParam(name = "town", required = false) String town,
            @RequestParam(name = "age", required = false) Integer age
    ){

        if (course != null & town !=null & age != null) {
            return new ResponseEntity<>(customerRepository.findByAgeGreaterThanAndTownIgnoreCaseAndBookingsCourseNameIgnoreCase(age, town, course), HttpStatus.OK);
        }

        if (course != null & town !=null) {
            return new ResponseEntity<>(customerRepository.findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(town, course), HttpStatus.OK);
        }

        if (course != null){
            return new ResponseEntity<>(customerRepository.findByBookingsCourseNameIgnoreCase(course), HttpStatus.OK);
        }
        return new ResponseEntity<List<Customer>>(customerRepository.findAll(), HttpStatus.I_AM_A_TEAPOT);
    }

}
