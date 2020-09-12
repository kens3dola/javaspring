package springmvc.dao;

import java.util.List;

import springmvc.model.Material;

public interface MaterialDAO {
	public void create(Material material);

	public void update(Material material);

	public void delete(int materialID);
	
	public Material get(int materialID);
	
	public void upload(int materialID, byte[] file);
	
	public List<Material> list(String courseID);
	
	public byte[] file(int materialID);
}
