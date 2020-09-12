package springmvc.model;

public class Material {
	private int materialID;
	private String content;
	private String courseID;
	private String link;
	private byte[] file;
	public Material() {
		
	}
	public Material(int materialID, String content, String courseID, String link, byte[] file) {
		super();
		this.materialID = materialID;
		this.content = content;
		this.courseID = courseID;
		this.link = link;
		this.file = file;
	}
	public int getMaterialID() {
		return materialID;
	}
	public void setMaterialID(int materialID) {
		this.materialID = materialID;
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
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] blob) {
		this.file = blob;
	}
	public Material(int materialID, String content, String courseID) {
		super();
		this.materialID = materialID;
		this.content = content;
		this.courseID = courseID;
	}
	@Override
	public String toString() {
		return "Material [materialID=" + materialID + ", content=" + content + ", courseID=" + courseID + ", link="
				+ link + ", fileID=" + file + "]";
	}
	
	
}
