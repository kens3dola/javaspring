package springmvc.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import springmvc.dao.StudentDAO;
import springmvc.model.Student;

public class StudentDAOImpl implements StudentDAO {

	private JdbcTemplate jdbc;
	
	public StudentDAOImpl(DataSource datasourse) {
		jdbc = new JdbcTemplate(datasourse);
	}
	@Override
	public void create(Student student) {
		String sql = "insert into Student value(?,?,?,?,?,?)";
		jdbc.update(sql, student.getStudentID(), student.getFirstName(), student.getLastName(), student.getGender(), student.getAddress(), student.getUserName());
	}

	@Override
	public void update(Student student) {
		String sql = "update Student set firstName=?, lastName=?, gender=?, address=? where studentID=?";
		jdbc.update(sql, student.getFirstName(), student.getLastName(), student.getGender(), student.getAddress(), student.getStudentID());
	}

	@Override
	public Student get(int studentID) {
		String sql = "select * from Student where studentID="+studentID;
		return jdbc.query(sql, new ResultSetExtractor<Student>() {

			@Override
			public Student extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					return new Student(rs.getInt("studentID"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("gender"), rs.getString("address"),rs.getString("User_Name"));
				}
				return null;
			}
			
		});
	};

	@Override
	public List<Student> list() {
		String sql = "select * from Student";
		return jdbc.query(sql, new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
					return new Student(rs.getInt("studentID"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("gender"), rs.getString("address"),rs.getString("User_Name"));					
			}
		});
	}
	@Override
	public Student get(String userName) {
		String sql = "select * from Student where User_Name='"+userName+"'";
		return jdbc.query(sql, new ResultSetExtractor<Student>() {

			@Override
			public Student extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					return new Student(rs.getInt("studentID"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("gender"), rs.getString("address"),rs.getString("User_Name"));
				}
				return null;
			}
			
		});
	}

}
