package springmvc.model;

public class Enrolment {
	private int enrolmentID;
	private int studentID;
	private String courseID;
	private String gradeCode;
	
	public int getEnrolmentID() {
		return enrolmentID;
	}
	public void setEnrolmentID(int enrolmentID) {
		this.enrolmentID = enrolmentID;
	}
	public Enrolment() {}
	public Enrolment(int enrolmentID, int studentID, String courseID, String gradeCode) {
		super();
		this.enrolmentID = enrolmentID;
		this.studentID = studentID;
		this.courseID = courseID;
		this.gradeCode = gradeCode;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getGradeCode() {
		return gradeCode;
	}
	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	};
	
}
