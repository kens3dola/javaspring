package springmvc.model;

import java.sql.Date;

public class Comment {
	private int commentID;
	private int forumID;
	private String content;
	private String userName;
	private Date date;
	
	@Override
	public String toString() {
		return "Comment [commentID=" + commentID + ", forumID=" + forumID + ", content=" + content + ", userName="
				+ userName + ", date=" + date + "]";
	}

	public Comment() {
		
	}
	
	public int getForumID() {
		return forumID;
	}

	public void setForumID(int forumID) {
		this.forumID = forumID;
	}

	public Comment(int commentID, int forumID, String content, String userName, Date date) {
		super();
		this.commentID = commentID;
		this.content = content;
		this.userName = userName;
		this.date = date;
	}
	
	public int getCommentID() {
		return commentID;
	}

	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	};
	
}
