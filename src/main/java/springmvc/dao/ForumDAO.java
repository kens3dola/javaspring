package springmvc.dao;

import java.util.List;

import springmvc.model.Forum;

public interface ForumDAO {
	public void create(Forum forum);

	public void update(Forum forum, int forumID);

	public void delete(int forumID);
	
	public Forum get(int forumID);

	public List<Forum> list(String courseID);
}
