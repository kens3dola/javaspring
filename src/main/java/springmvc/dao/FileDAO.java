package springmvc.dao;

import java.util.List;

import springmvc.model.FileAs;

public interface FileDAO {
	public void create(FileAs file);

	public void update(FileAs file);

	public FileAs get(int fileID);
	
	public FileAs get(int assignmentID, String userName);
	
	public List<FileAs> list(int assignmentID);
	
	public void delete(int fileID);
	
	public byte[] fileAs(int fileID);
}
