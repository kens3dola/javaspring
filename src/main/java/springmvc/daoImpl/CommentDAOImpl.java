package springmvc.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import springmvc.dao.CommentDAO;
import springmvc.model.Comment;

public class CommentDAOImpl implements CommentDAO {

	private JdbcTemplate jdbcTemplate;

	public CommentDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void create(Comment comment) {
		String sql = "insert into comment_forum(forumID,content_Forum,User_Name) values(?,?,?)";
		jdbcTemplate.update(sql, comment.getForumID(), comment.getContent(), comment.getUserName());

	}

	@Override
	public void update(Comment comment) {
		String sql = "update Student set forumID=?,content_Forum=?,User_Name=? ,commentDate=? where commentID=?";
		jdbcTemplate.update(sql,comment.getForumID(), comment.getContent(), comment.getUserName(), comment.getDate() ,comment.getCommentID());

	}

	@Override
	public void delete(int commentID) {
		String sql = "DELETE FROM comment_forum WHERE commentID=?";
		jdbcTemplate.update(sql, commentID);

	}

	@Override
	public List<Comment> list(int forumID) {
		String sql = "select * from comment_forum where forumID=" + forumID;
		return jdbcTemplate.query(sql, new RowMapper<Comment>() {
			@Override
			public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
					return new Comment(rs.getInt("commentID"),rs.getInt("forumID"),rs.getString("content_Forum"),rs.getString("User_Name"),rs.getDate("commmentDate"));
			}
		});
	}

}