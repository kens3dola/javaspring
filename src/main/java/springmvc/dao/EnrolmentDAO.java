package springmvc.dao;

import java.util.List;

import springmvc.model.Enrolment;


public interface EnrolmentDAO {
	 public void enrol(int studentID, String courseID);
	    
	 public void unenrol(int studentID, String courseID);
	 
	 public void enterMark(Enrolment enrolment);
	
	 public Enrolment isEnroll(int studentID, String courseID);
	 
	 public List<Enrolment> list(int studentID);
	 
	 public List<Enrolment> restlist(int studentID);
	 
	 public List<Enrolment> stnList(String courseID);
	 
	 public Enrolment getEnrolment(int enrolmentID);
}
