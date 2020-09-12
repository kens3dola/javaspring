package springmvc.dao;

import java.util.List;

import springmvc.model.Comment;

public interface CommentDAO {
	public void create(Comment comment);

	public void update(Comment comment);

	public void delete(int commentID);

	public List<Comment> list(int Forum);
}
