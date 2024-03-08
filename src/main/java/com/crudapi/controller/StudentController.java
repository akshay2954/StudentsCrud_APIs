package com.crudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudapi.entity.Student;
import com.crudapi.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	 @Autowired
	    private StudentService studentService;

	    @GetMapping
	    public List<Student> getAllStudents() {
	        return studentService.getAllStudents();
	    }

	    @PostMapping
	    public Student createStudent(@RequestBody Student student) {
	        return studentService.createStudent(student);
	    }

	    @PutMapping("/{id}")
	    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
	        student.setId(id);
	        return studentService.updateStudent(student);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteStudent(@PathVariable Long id) {
	        studentService.deleteStudent(id);
	    }

}
