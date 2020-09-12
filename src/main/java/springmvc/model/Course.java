package springmvc.model;

import java.sql.Date;

public class Course {
	private String courseID;
	private int teacherID;
	private String courseName;
	private int maxStudent;
	private Date start;
	private Date end;
	public Course() {}
	public Course(String courseID,int teacherID, String courseName, int maxStudent, Date start, Date end) {
		super();
		this.courseID = courseID;
		this.teacherID = teacherID;
		this.courseName = courseName;
		this.maxStudent = maxStudent;
		this.start = start;
		this.end = end;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public int getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getMaxStudent() {
		return maxStudent;
	}
	public void setMaxStudent(int maxStudent) {
		this.maxStudent = maxStudent;
	};
	
}
