package com.student.service;

import com.student.dao.StudentDao;
import com.student.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentDao studentDao;

    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public boolean saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }

    public Student getStudent(int id) {
        return studentDao.getStudent(id);
    }

    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }
}
