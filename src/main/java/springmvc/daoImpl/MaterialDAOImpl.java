package springmvc.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import springmvc.dao.MaterialDAO;
import springmvc.model.Material;
public class MaterialDAOImpl implements MaterialDAO {

	private JdbcTemplate jdbcTemplate;

	public MaterialDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}


	@Override
	public void delete(int materialID) {
		String sql = "delete from material where materialID="+materialID;
		jdbcTemplate.update(sql);
	}

	@Override
	public List<Material> list(String courseID) {
		String sql = "select * from material where courseID='"+courseID+"'";
		List<Material> listMaterial = jdbcTemplate.query(sql, new RowMapper<Material>() {

			@Override
			public Material mapRow(ResultSet rs, int rowNum) throws SQLException {
				Material material = new Material();
				material.setMaterialID(rs.getInt("materialID"));
				material.setContent(rs.getString("content"));
				material.setCourseID(rs.getString("courseID"));
				material.setLink(rs.getString("link"));
				return material;
			}
		});
		return listMaterial;

	}
	@Override
	public Material get(int materialID) {
		String sql = "select * from material where materialID="+materialID;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Material>() {

			@Override
			public Material extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					return new Material(rs.getInt("materialID"),rs.getString("content"),rs.getString("courseID"),rs.getString("link"), rs.getBytes("filecontent"));
				}
				return null;
			}
			
		});
	}


	@Override
	public void create(Material material) {
			if(material.getLink()!=null) {
			String sql = "insert into material(content, courseID, link) value(?,?,?)";
			jdbcTemplate.update(sql, material.getContent(), material.getCourseID(), material.getLink());
			}else if(material.getFile()!=null) {
				String sql ="insert into material(content, courseID, fileID) value(?,?,?)";
				jdbcTemplate.update(sql, material.getContent(), material.getCourseID(), material.getFile());
			}else{
				String sql="insert into material(content, courseID, link, fileID) value(?,?,?,?)";
				jdbcTemplate.update(sql,material.getContent(), material.getCourseID(), material.getLink(), material.getFile());
			}
		}


	@Override
	public void update(Material material) {
	}


	@Override
	public void upload(int materialID, byte[] file) {
		String sql = "update material set filecontent =? where materialID="+ materialID;
		jdbcTemplate.update(sql, file);
	}


	@Override
	public byte[] file(int materialID) {
		String sql = "select filecontent from material where materialID="+materialID;
		return jdbcTemplate.query(sql, new ResultSetExtractor<byte[]>() {

			@Override
			public byte[] extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					return rs.getBytes("filecontent");
				}
				return null;
			}
			
		});
	} 

}
