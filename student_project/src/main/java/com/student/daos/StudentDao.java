package com.student.daos;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.entities.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Long>{

}


