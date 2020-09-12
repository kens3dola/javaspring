package springmvc.model;

public class Teacher {
	private int teacherID;
	private String teacherName;
	private String userName;
	private String gender;
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Teacher() {
	}

	public int getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Teacher(int teacherID, String teacherName, String userName, String gender) {
		this.teacherID = teacherID;
		this.teacherName = teacherName;
		this.userName = userName;
		this.gender = gender;
	};
	
}
