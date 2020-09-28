package com.student.controller;

import com.student.domain.Student;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class MainController {

    private StudentService studentService;

    @Autowired
    public MainController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student")
    public ResponseEntity<String> saveStudent(@RequestPart final Student student) {
        boolean result = studentService.saveStudent(student);
        if (result)
            return ResponseEntity.ok("Student Created Successfully!!!");
        else
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable final int id) {
        Student student = studentService.getStudent(id);
        return ResponseEntity.ok().body(student);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> findAllStudent() {
        List<Student> getAllStudent = studentService.getAllStudents();
        return ResponseEntity.ok().body(getAllStudent);
    }
}
