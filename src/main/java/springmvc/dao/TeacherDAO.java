package springmvc.dao;

import java.util.List;

import springmvc.model.Teacher;


public interface TeacherDAO {
	 public void create(Teacher teacher);
	    
	    public void update(Teacher teacher);
	    
	    public Teacher get(int teacherID);
	    
	    public Teacher get(String userName);
	     
	    public List<Teacher> list();
	    
}
