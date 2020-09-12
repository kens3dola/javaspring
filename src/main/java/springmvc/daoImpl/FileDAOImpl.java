package springmvc.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import springmvc.dao.FileDAO;
import springmvc.model.FileAs;

public class FileDAOImpl implements FileDAO {

	
	private JdbcTemplate jdbcTemplate;

	public FileDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public void create(FileAs file) {
		String sql = "insert into fileassignment(assignmentID, title, content,username) values(?,?,?,?)";
		jdbcTemplate.update(sql, file.getAssignmentID(), file.getTitle(),file.getFile(),file.getUserName());
	}

	@Override
	public void update(FileAs file) {
		String sql = "update fileassignment set title=?, content=? where fileID =?";
		jdbcTemplate.update(sql, file.getTitle(), file.getFile(), file.getFileID());
	}

	@Override
	public FileAs get(int fileID) {
		String sql = "select * from fileassignment where fileID ="+fileID;
		return jdbcTemplate.query(sql, new ResultSetExtractor<FileAs>() {

			@Override
			public FileAs extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					return new FileAs(rs.getInt("fileID"), rs.getInt("assignmentID"),rs.getString("title"),rs.getBytes("content"),rs.getString("userName"));
				}
				return null;
			}
		});
	};

	@Override
	public List<FileAs> list(int assignmentID) {
		String sql1 = "SELECT * FROM fileassignment WHERE assignmentID="+assignmentID;
		List<FileAs> listFile = jdbcTemplate.query(sql1, new RowMapper<FileAs>() {

			@Override
			public FileAs mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new FileAs(rs.getInt("fileID"), rs.getInt("assignmentID"),rs.getString("title"),rs.getBytes("content"),rs.getString("userName"));
			}
		});
		return listFile;

	}
	@Override
	public FileAs get(int assignmentID, String userName) {
		String sql = "select * from fileassignment where assignmentID =" +assignmentID+" and username='"+userName+"'"; 
		return jdbcTemplate.query(sql, new ResultSetExtractor<FileAs>() {

			@Override
			public FileAs extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
//					File file = new File();
//					file.setFileID(rs.getInt("fileID"));
//					file.setAssignmentID(rs.getInt("assignmentID"));
//					file.setCourseID(rs.getString("courseID"));
//					file.setTitle(rs.getString("title"));
//					file.setFile(rs.getBlob("content"));
					return new FileAs(rs.getInt("fileID"),rs.getInt("assignmentID"),rs.getString("title"),rs.getBytes("content"),rs.getString("username"));
				}
				return null;
			}
		});
}
	@Override
	public void delete(int fileID) {
		jdbcTemplate.update("delete from fileassignment where fileID="+fileID);
	}
	@Override
	public byte[] fileAs(int fileID) {
		String sql = "select content from fileassignment where fileID = "+fileID;
		return jdbcTemplate.query(sql, new ResultSetExtractor<byte[]>() {

			@Override
			public byte[] extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					return rs.getBytes("content");
				}
				return null;
			}
			
		});
	}
}
