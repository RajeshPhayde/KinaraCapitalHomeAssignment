package com.student.management.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.management.module.Student;
import com.student.management.repo.StudentRepo;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {

	@Autowired
	 private final StudentRepo repo;

	    public StudentController(StudentRepo repo) {
	        this.repo = repo;
	    }

	    @RequestMapping("/students")
	    public String getStudents(HttpSession h1,
	            @RequestParam(defaultValue = "1") int page,
	            @RequestParam(defaultValue = "10") int pageSize
	    ) {
	    	if(page<1) {
	    		page=1;
	    	}
	        Pageable pageable = PageRequest.of(page-1, pageSize);
	        Page<Student> studentPage = repo.findAll(pageable);
	        

	        Student s = repo.getStudent(page);
	        
	        if(s!=null) {
	        	h1.setAttribute("id", s.getId());
	        	h1.setAttribute("name", s.getName());
	        	h1.setAttribute("totalMarks", s.getTotalmarks());
	        	h1.setAttribute("message", null);
	        }
	        else {
	        	h1.setAttribute("id", null);
	        	h1.setAttribute("name", null);
	        	h1.setAttribute("totalMarks", null);	
	        	h1.setAttribute("message", "Student details not found...!!!");
	        }
	        
	        h1.setAttribute("currentPage", page);

	        return "student-page.jsp"; 
	    }
	 
}
