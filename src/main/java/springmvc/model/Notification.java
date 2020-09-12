package springmvc.model;

import java.sql.Date;

public class Notification {
	private int notificationID;
	private int teacherID;
	private String title;
	private String content;
	private Date date;
	public Notification() {
		
	}
	public int getNotificationID() {
		return notificationID;
	}
	public Notification(int notificationID, int teacherID, String title, String content, Date date) {
		super();
		this.notificationID = notificationID;
		this.teacherID = teacherID;
		this.title = title;
		this.content = content;
		this.date = date;
	}
	public void setNotificationID(int notificationID) {
		this.notificationID = notificationID;
	}
	public int getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	};
	
}
