package springmvc.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import springmvc.dao.AssignmentDAO;
import springmvc.model.Assignment;

public class AssignmentDAOImpl implements AssignmentDAO {

	private JdbcTemplate jdbcTemplate;

	public AssignmentDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(Assignment assignment) {
		String sql = "insert into assignment(courseID, assignment_title,assignment_startDate, assignment_endDate) values(?,?,?,?)";
		jdbcTemplate.update(sql, assignment.getCourseID(), assignment.getTitle(), assignment.getStart(),
				assignment.getEnd());
	}

	@Override
	public void update(Assignment assignment, int assignmentID) {
		// TODO Auto-generated method stub
		String sql = "update assignment set assignment_title='"+assignment.getTitle()+"', assignment_startDate='"+assignment.getStart()+"', assignment_endDate='"+assignment.getEnd()+"' where assignmentID="	+ assignmentID;
		jdbcTemplate.update(sql);
	}

	@Override
	public void delete(int assignmentID) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM assignment WHERE assignmentID=?";
		jdbcTemplate.update(sql, assignmentID);

	}

	@Override
	public Assignment get(int assignmentID) {
		String sql = "select * from assignment where assignmentID=" + assignmentID;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Assignment>() {

			@Override
			public Assignment extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					return new Assignment(rs.getInt("assignmentID"), rs.getString("courseID"),
							rs.getString("assignment_title"), rs.getDate("assignment_startDate"),
							rs.getDate("assignment_endDate"));
				}
				return null;
			}

		});
	}

	@Override
	public List<Assignment> list(String courseID) {
		String sql = "select * from assignment where courseID='" + courseID+"'";
		return jdbcTemplate.query(sql, new RowMapper<Assignment>() {
			@Override
			public Assignment mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Assignment(rs.getInt("assignmentID"), rs.getString("courseID"),
						rs.getString("assignment_title"), rs.getDate("assignment_startDate"),
						rs.getDate("assignment_endDate"));
			}
		});
	}

}