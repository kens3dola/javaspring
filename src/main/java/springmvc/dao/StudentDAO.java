package springmvc.dao;

import java.util.List;

import springmvc.model.Student;

public interface StudentDAO {
    public void create(Student student);
    
    public void update(Student student);
    
    public Student get(int studentID);
    
    public Student get(String userName);
     
    public List<Student> list();
}
