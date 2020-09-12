package springmvc.model;

import java.sql.Date;

public class Assignment {
	private int assignmentID;
	private String courseID;
	private String title;
	private Date start;
	private Date end;
	
	public Assignment() {}

	public Assignment(int assignmentID, String courseID, String title, Date start, Date end) {
		super();
		this.assignmentID = assignmentID;
		this.courseID = courseID;
		this.title = title;
		this.start = start;
		this.end = end;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public int getAssignmentID() {
		return assignmentID;
	}
	public void setAssignmentID(int assignmentID) {
		this.assignmentID = assignmentID;
	}

	@Override
	public String toString() {
		return "Assignment [assignmentID=" + assignmentID + ", courseID=" + courseID + ", title=" + title + ", start="
				+ start + ", end=" + end + "]";
	}
	
}
