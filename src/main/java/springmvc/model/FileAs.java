package springmvc.model;

public class FileAs {
	private int fileID;
	private int assignmentID;
	private String title;
	private byte[] file;
	private String userName;

	public FileAs(int fileID, int assignmentID, String title, byte[] file, String userName) {
		super();
		this.fileID = fileID;
		this.assignmentID = assignmentID;
		this.title = title;
		this.file = file;
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public FileAs() {
	}

	public FileAs(int assignmentID, String title, byte[] file) {
		super();
		this.assignmentID = assignmentID;
		this.title = title;
		this.file = file;
	}

	public int getAssignmentID() {
		return assignmentID;
	}

	public void setAssignmentID(int assignmentID) {
		this.assignmentID = assignmentID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getFileID() {
		return fileID;
	}

	public void setFileID(int fileID) {
		this.fileID = fileID;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	
}
