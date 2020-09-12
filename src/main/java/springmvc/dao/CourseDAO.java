package springmvc.dao;

import java.util.List;

import springmvc.model.Course;

public interface CourseDAO {
	 public void create(Course course);
	    
	    public void update(Course course);
	    
	    public void delete(String courseID);
	    
	    public Course get(String courseID);
	     
	    public List<Course> list();
	    
	    public List<Course> teachList(int teacherID);
}
