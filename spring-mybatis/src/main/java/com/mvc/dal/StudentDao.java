package com.mvc.dal;

import com.mvc.entity.Student;

import java.util.List;

public interface StudentDao {
	public List<Student> selectAll();
	public Student select(final Student student);
	public void save(final Student student);
	public void saveAll(final List<Student> students);
	public void update(final Student student);
	public void updateAll(final List<Student> students);
	public void delete(final Student student);
}
