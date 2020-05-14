package com.codeclan.example.course.booking.controllers;

import com.codeclan.example.course.booking.models.Course;
import com.codeclan.example.course.booking.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRange;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCourses(
            @RequestParam(name = "rating", required = false) Integer rating,
            @RequestParam(name = "customer", required = false) String customerName
    ){
        if (rating != null){
            return new ResponseEntity<List<Course>>(courseRepository.findByRating(rating), HttpStatus.OK);
        }

        if (customerName != null){
            return new ResponseEntity<List<Course>>(courseRepository.findByBookingsCustomerNameIgnoreCase(customerName), HttpStatus.OK);
        }

        return new ResponseEntity<List<Course>>(courseRepository.findAll(), HttpStatus.OK);
    }
}
