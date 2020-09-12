package springmvc.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import springmvc.dao.TeacherDAO;
import springmvc.model.Teacher;

public class TeacherDAOImpl implements TeacherDAO {

	private JdbcTemplate jdbcTemplate;

	public TeacherDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void create(Teacher teacher) {
		String sql = "insert into teacher values(?,?,?,?)";
		jdbcTemplate.update(sql, teacher.getTeacherID(),teacher.getTeacherName(), teacher.getUserName(),teacher.getGender());
	}

	@Override
	public void update(Teacher teacher) {
		String sql = "update teacher set teacherName =?, User_Name=?, gender=? where teacherID=?";
		jdbcTemplate.update(sql, teacher.getTeacherName(), teacher.getUserName(),teacher.getGender(),teacher.getTeacherID());
	}

	@Override
	public Teacher get(int teacherID) {
		String sql = "select * from teacher where teacherID="+teacherID;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Teacher>() {

			@Override
			public Teacher extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					return new Teacher(rs.getInt("teacherID"),rs.getString("teacherName"),rs.getString("User_Name"),rs.getString("gender"));
				}
				return null;
			}
			
		});
	}

	@Override
	public List<Teacher> list() {
		String sql = "select * from teacher";
		return jdbcTemplate.query(sql, new RowMapper<Teacher>() {
			@Override
			public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
					return new Teacher(rs.getInt("teacherID"),rs.getString("teacherName"),rs.getString("User_Name"),rs.getString("gender"));
			}
		});
		
	}

	@Override
	public Teacher get(String userName) {
		String sql = "select * from teacher where User_Name='"+userName+"'";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Teacher>() {

			@Override
			public Teacher extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					return new Teacher(rs.getInt("teacherID"),rs.getString("teacherName"),rs.getString("User_Name"),rs.getString("gender"));
				}
				return null;
			}
			
		});
}};