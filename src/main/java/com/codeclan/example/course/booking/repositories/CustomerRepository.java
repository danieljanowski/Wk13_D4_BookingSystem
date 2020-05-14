package com.codeclan.example.course.booking.repositories;

import com.codeclan.example.course.booking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByBookingsCourseNameIgnoreCase(String courseName);
    List<Customer> findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(String town, String courseName);
    List<Customer> findByAgeGreaterThanAndTownIgnoreCaseAndBookingsCourseNameIgnoreCase(Integer age, String town, String courseName);
}
