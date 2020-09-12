package springmvc.model;


public class Account {
	private String userName;
	private String passWord;
	private String userRole;
	
	public Account() {
	};
	public Account(String userName, String passWord, String userRole) {
		this.userName = userName;
		this.passWord = passWord;
		this.userRole = userRole;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	@Override
	public String toString() {
		return "Account [userName=" + userName + ", passWord=" + passWord + ", userRole=" + userRole + "]";
	}
}