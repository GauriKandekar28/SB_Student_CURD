package com.tech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.dao.Student_Dao;
import com.tech.dto.Student;

@Service
public class Student_Service {
	
	@Autowired
	Student_Dao studentDao;
	

	public Iterable<Student> getAllStudents() {
        return studentDao.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentDao.findById(id);
    }

    public Student saveStudent(Student student) {
        return studentDao.save(student);
    }

    public void deleteStudent(Long id) {
    	studentDao.deleteById(id);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Optional<Student> studentOptional = studentDao.findById(id);
        if (studentOptional.isPresent()) {
            Student existingStudent = studentOptional.get();
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setEmail(updatedStudent.getEmail());
            existingStudent.setAge(updatedStudent.getAge());
            existingStudent.setGender(updatedStudent.getGender());
            return studentDao.save(existingStudent);
        } else {
            throw new RuntimeException("Student not found with id: " + id);
        }
    }

}
