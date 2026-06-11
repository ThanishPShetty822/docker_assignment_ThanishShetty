package org.example.service;

import org.example.model.Student;
import org.example.repo.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student addStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudent(int id) {
        return repository.findById(id)
                .orElse(null);
    }

    public Student updateStudent(int id, Student updatedStudent) {

        Student existingStudent = repository.findById(id)
                .orElse(null);

        if (existingStudent != null) {

            existingStudent.setName(updatedStudent.getName());
            existingStudent.setEmail(updatedStudent.getEmail());

            return repository.save(existingStudent);
        }

        return null;
    }

    public void deleteStudent(int id) {
        repository.deleteById(id);
    }
}