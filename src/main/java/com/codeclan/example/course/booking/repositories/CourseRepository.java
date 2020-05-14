package com.codeclan.example.course.booking.repositories;

import com.codeclan.example.course.booking.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByRating(Integer rating);

    List<Course> findByBookingsCustomerNameIgnoreCase(String customerName);
}