package com.tech.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tech.dto.Student;
@Repository
public interface Student_Dao extends CrudRepository<Student, Long>{

}
