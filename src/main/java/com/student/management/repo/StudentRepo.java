package com.student.management.repo;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.student.management.module.Student;


public interface StudentRepo extends JpaRepository<Student, Integer>{

	 Page<Student> findAll(Pageable pageable);

	 Page<Student> findAllByIdGreaterThan(int id, Pageable pageable);
	
	 @Query(value = "select * from student where id=?1", nativeQuery = true)
	 Student getStudent(int id);
}
