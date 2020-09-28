package com.student.dao;

import com.student.domain.Student;
import com.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDao {

    private StudentRepository studentRepository;
    private RedisTemplate redisTemplate;

    private static  final String KEY = "USER";

    @Autowired
    public StudentDao(StudentRepository studentRepository, RedisTemplate redisTemplate) {
        this.studentRepository = studentRepository;
        this.redisTemplate = redisTemplate;
    }

    public boolean saveStudent(Student student) {
        try {
            redisTemplate.opsForHash().put(KEY, student.getId().toString(), student);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return  false;
        }
    }

    public Student getStudent(int id) {
        Student student = studentRepository.getOne(id);;
        return student;
    }

    public List<Student> getAllStudents() {
        List<Student> students;
        students = redisTemplate.opsForHash().values(KEY);
        return students;
    }
}
