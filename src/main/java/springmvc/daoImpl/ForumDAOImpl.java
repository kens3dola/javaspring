package springmvc.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import springmvc.dao.ForumDAO;
import springmvc.model.Forum;

public class ForumDAOImpl implements ForumDAO {

	private JdbcTemplate jdbcTemplate;

	public ForumDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void create(Forum forum) {
		String sql= "insert into forum(forum_title, content, courseID) values( ?, ?, ?)";
		jdbcTemplate.update(sql, forum.getTitle(), forum.getContent(), forum.getCourseID());
	}

	@Override
	public void update(Forum forum, int forumID) {
	String sql= "update forum set forum_title='"+forum.getTitle()+"', content='"+forum.getContent()+"' where forumID="+forumID;
	jdbcTemplate.update(sql);
}

	@Override
	public void delete(int forumID) {
		String sql= "DELETE FROM forum WHERE forumID =?";
		jdbcTemplate.update(sql, forumID);
	}

	@Override
	public List<Forum> list(String courseID) {
	String sql = "SELECT * FROM forum WHERE courseID ='" + courseID+"'";
	return jdbcTemplate.query(sql, new RowMapper<Forum>() {
		@Override
		public Forum mapRow(ResultSet rs, int rowNum) throws SQLException{
		      return new Forum(rs.getInt("forumID"), rs.getString("forum_title"), rs.getString("content"), rs.getString("courseID"));
		}

	});
	}

	@Override
	public Forum get(int forumID) {
		String sql = "select * from forum where forumID="+forumID;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Forum>() {

			@Override
			public Forum extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					return new Forum(forumID,rs.getString("forum_title"),rs.getString("content"),rs.getString("courseID"));
				}
				return null;
			}
			
		});
	}

}