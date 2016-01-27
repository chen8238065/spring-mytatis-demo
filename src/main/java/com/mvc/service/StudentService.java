package com.mvc.service;

import com.mvc.dal.StudentDao;
import com.mvc.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {
	@Autowired
	private StudentDao studentDao;
	
	@Transactional
	public List<Student> getStudentList(){

		List<Student> list = studentDao.selectAll();
		return list;
	}
	
	public void save(Student st){
		studentDao.save(st);
	}

	public void delete(Student obj){
		studentDao.delete(obj);
	}
}
