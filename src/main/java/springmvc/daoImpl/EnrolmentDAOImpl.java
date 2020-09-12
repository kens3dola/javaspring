package springmvc.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import springmvc.dao.EnrolmentDAO;
import springmvc.model.Enrolment;

public class EnrolmentDAOImpl implements EnrolmentDAO {

	private JdbcTemplate jdbcTemplate;

	public EnrolmentDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void enrol(int studentID, String courseID) {
		String sql = "insert into enrolment(studentID,courseID) values(?, ?)";
		jdbcTemplate.update(sql, studentID, courseID);

	}

	@Override
	public void unenrol(int studentID, String courseID) {
		String sql = "DELETE FROM enrolment WHERE studentID=? and courseID=?";
		jdbcTemplate.update(sql, studentID, courseID);

	}

	@Override
	public void enterMark(Enrolment enrolment) {
		String sql = "update enrolment set grade_code='"+enrolment.getGradeCode()+"' where enrolmentID="+enrolment.getEnrolmentID();
		jdbcTemplate.update(sql);
	}

	@Override
	public List<Enrolment> list(int studentID) {
		String sql = "select * from enrolment where studentID=" + studentID;
		return jdbcTemplate.query(sql, new RowMapper<Enrolment>() {
			@Override
			public Enrolment mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Enrolment(rs.getInt("enrolmentID"), rs.getInt("studentID"), rs.getString("courseID"),
						rs.getString("grade_code"));
			}
		});

	}

	@Override
	public List<Enrolment> restlist(int studentID) {
		String sql = "select * from enrolment where studentID<>" + studentID;
		return jdbcTemplate.query(sql, new RowMapper<Enrolment>() {
			@Override
			public Enrolment mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Enrolment(rs.getInt("enrolmentID"), rs.getInt("studentID"), rs.getString("courseID"),
						rs.getString("grade_code"));
			}
		});

	}

	@Override
	public List<Enrolment> stnList(String courseID) {
		String sql = "select * from enrolment where courseID='" + courseID + "'";
		return jdbcTemplate.query(sql, new RowMapper<Enrolment>() {
			@Override
			public Enrolment mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Enrolment(rs.getInt("enrolmentID"), rs.getInt("studentID"), rs.getString("courseID"),
						rs.getString("grade_code"));
			}
		});
	}

	@Override
	public Enrolment isEnroll(int studentID, String courseID) {
		String sql = "select * from enrolment where studentID=" + studentID + " and courseID='" + courseID + "'";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Enrolment>() {

			@Override
			public Enrolment extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					return new Enrolment(rs.getInt("enrolmentID"), rs.getInt("studentID"), rs.getString("courseID"),
							rs.getString("grade_code"));
				}
				return null;
			}

		});
	}

	@Override
	public Enrolment getEnrolment(int enrolmentID) {
		String sql = "select * from enrolment where enrolmentID = " + enrolmentID;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Enrolment>() {

			@Override
			public Enrolment extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					return new Enrolment(rs.getInt("enrolmentID"), rs.getInt("studentID"), rs.getString("courseID"),
							rs.getString("grade_code"));
				}
				return null;
			}

		});
	}
}