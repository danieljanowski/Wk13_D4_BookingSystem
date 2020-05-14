package com.codeclan.example.course.booking.components;

import com.codeclan.example.course.booking.models.Booking;
import com.codeclan.example.course.booking.models.Course;
import com.codeclan.example.course.booking.models.Customer;
import com.codeclan.example.course.booking.repositories.BookingRepository;
import com.codeclan.example.course.booking.repositories.CourseRepository;
import com.codeclan.example.course.booking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {
        Course javascript = new Course("JavaScript","Portlethen",5);
        courseRepository.save(javascript);
        Course ruby = new Course("Ruby", "Edinburgh", 3);
        courseRepository.save(ruby);
        Course python = new Course("Python", "Edinburgh", 3);
        courseRepository.save(python);


        Customer adam = new Customer("Adam Petrie","Portlethen", 23);
        customerRepository.save(adam);
        Customer daniel = new Customer("Daniel Janowski","Gorebridge", 42);
        customerRepository.save(daniel);
        Customer george = new Customer("George Michael","London", 56);
        customerRepository.save(george);


        Booking booking1 = new Booking("25-06-20", javascript, adam);
        bookingRepository.save(booking1);
        Booking booking2 = new Booking("25-06-20", javascript, daniel);
        bookingRepository.save(booking2);
        Booking booking3 = new Booking("25-07-20", python, adam);
        bookingRepository.save(booking3);
        Booking booking4 = new Booking("25-07-20", python, george);
        bookingRepository.save(booking4);
    }
}
