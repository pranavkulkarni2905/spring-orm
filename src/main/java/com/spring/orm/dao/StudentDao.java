package com.spring.orm.dao;

import java.io.Serializable;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entities.Student;

public class StudentDao {
	
	HibernateTemplate hibernateTemplate;
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}


	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	@Transactional
	public int saveStudent(Student student) {
		Integer i =(Integer) this.hibernateTemplate.save(student);
		return i;
	}
	
	public Student getStudent(int id) {
		Student student = this.hibernateTemplate.get(Student.class,id);
		return student;
	}
	
	public List<Student> getAllStudents(){
		
		List<Student> list = this.hibernateTemplate.loadAll(Student.class);
		return list;
	}
	
	@Transactional
	public void deleteStudent(int id) {
		Student student = this.hibernateTemplate.get(Student.class,id);
		this.hibernateTemplate.delete(student);
	}
	
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
	}
	
	
}
