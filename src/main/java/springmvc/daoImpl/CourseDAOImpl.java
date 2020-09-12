package springmvc.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import springmvc.dao.CourseDAO;
import springmvc.model.Course;

public class CourseDAOImpl implements CourseDAO {

	private JdbcTemplate jdbcTemplate;

	public CourseDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(Course course) {

		String sql = "insert into course value(?,?,?,?,?,?)";
		jdbcTemplate.update(sql, course.getCourseID(), course.getTeacherID(), course.getCourseName(),
				course.getMaxStudent(), course.getStart(), course.getEnd());
	}

	@Override
	public void update(Course course) {
		String sql = "update course set teacherID=?,courseName=?,Max_Student=?, start=?, end=? where courseID=?";
		jdbcTemplate.update(sql, course.getTeacherID(), course.getCourseName(), course.getMaxStudent(),
				course.getStart(), course.getEnd(), course.getCourseID());

	}

	@Override
	public void delete(String courseID) {
		String sql = "DELETE FROM course WHERE courseID="+"'"+courseID+"'";
		jdbcTemplate.update(sql);

	}

	@Override
	public Course get(String courseID) {
		String sql = "select * from course where courseID='"+courseID+"'";
		System.out.println(sql);
		return jdbcTemplate.query(sql,new ResultSetExtractor<Course>() {

			@Override
			public Course extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					return new Course(rs.getString("courseID"), rs.getInt("teacherID"), rs.getString("courseName"),
							rs.getInt("Max_Student"), rs.getDate("start"), rs.getDate("end"));
				}
				return null;
			}

		});
	}

	@Override
	public List<Course> list() {
		String sql = "select * from course";
		return jdbcTemplate.query(sql, new RowMapper<Course>() {
			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Course(rs.getString("courseID"), rs.getInt("teacherID"), rs.getString("courseName"),
						rs.getInt("Max_Student"), rs.getDate("start"), rs.getDate("end"));
			}
		});
	}

	@Override
	public List<Course> teachList(int teacherID) {
		String sql = "select * from course where teacherID="+teacherID;
		return jdbcTemplate.query(sql, new RowMapper<Course>() {
			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Course(rs.getString("courseID"), rs.getInt("teacherID"), rs.getString("courseName"),
						rs.getInt("Max_Student"), rs.getDate("start"), rs.getDate("end"));
			}
		});
	}

}