package springmvc.dao;

import java.util.List;

import springmvc.model.Assignment;

public interface AssignmentDAO {
	 public void create(Assignment assignment);
	    
	    public void update(Assignment assignment, int assignmentID);
	    
	    public void delete(int assignmentID);
	    
	    public Assignment get(int assignmentID);
	     
	    public List<Assignment> list(String courseID);
}
