package org.example.controller;

import org.example.model.Student;
import org.example.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public String addStudent(
            @RequestBody Student student) {

        service.addStudent(student);
        return "Student Added Successfully";
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(
            @PathVariable int id) {

        return service.getStudent(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable int id,
            @RequestBody Student student) {

        return service.updateStudent(
                id,
                student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(
            @PathVariable int id) {

        service.deleteStudent(id);
        return "Student Deleted Successfully";
    }
}