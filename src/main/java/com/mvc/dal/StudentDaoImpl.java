package com.mvc.dal;

import com.mvc.entity.Student;
import com.mvc.map.StudentMapper;

import javax.annotation.Resource;
import java.util.List;

public class StudentDaoImpl  implements StudentDao {
    @Resource
    private StudentMapper studentMapper;

    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }

    public Student select(Student student) {
        return null;
    }

    public void save(Student student) {
        studentMapper.insert(student);
    }

    public void saveAll(List<Student> students) {
        for (int i = 0; i <students.size() ; i++) {
            studentMapper.insert(students.get(i));
        }
    }

    public void update(Student student) {
        studentMapper.updateByPrimaryKey(student);
    }

    public void updateAll(List<Student> students) {
        for (int i = 0; i <students.size() ; i++) {
            studentMapper.updateByPrimaryKey(students.get(i));
        }
    }

    public void delete(Student student) {
        studentMapper.deleteByPrimaryKey(student.getId());
    }
}
