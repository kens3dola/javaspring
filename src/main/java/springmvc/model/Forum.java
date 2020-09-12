package springmvc.model;

public class Forum {
	private int forumID;
	private String title;
	private String content;
	private String courseID;
	public Forum() {}
	public Forum(int forumID, String title, String content, String courseID) {
		super();
		this.forumID = forumID;
		this.title = title;
		this.content = content;
		this.courseID = courseID;
	}
	
	public int getForumID() {
		return forumID;
	}
	public void setForumID(int forumID) {
		this.forumID = forumID;
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
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	};
	
}
