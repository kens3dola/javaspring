package springmvc.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import springmvc.dao.NotificationDAO;
import springmvc.model.Notification;

public class NotificationDAOImpl implements NotificationDAO {

	private JdbcTemplate jdbcTemplate;

	public NotificationDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(Notification notification) {
		String sql = "insert into notification(teacherID,notificationTitle,notificationContent) value(?,?,?)";
		jdbcTemplate.update(sql, notification.getTeacherID(), notification.getTitle(), notification.getContent());

	}

	@Override
	public void update(Notification notification) {
		String sql = "update notification set teacherID=?,notificationTitle=?,notificationContent=?,notitficationDate=? where notificationID=?";
		jdbcTemplate.update(sql, notification.getTeacherID(), notification.getTitle(), notification.getContent(),
				notification.getDate(), notification.getNotificationID());
	}

	@Override
	public void delete(int notificationID) {
		String sql = "DELETE FROM notification WHERE notificationID=?";
		jdbcTemplate.update(sql, notificationID);

	}

	@Override
	public List<Notification> list() {
		String sql = "select * from notification";
		return jdbcTemplate.query(sql, new RowMapper<Notification>() {
			@Override
			public Notification mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Notification(rs.getInt("notificationID"), rs.getInt("teacherID"),
						rs.getString("notificationTitle"), rs.getString("notificationContent"),
						rs.getDate("notificationDate"));
			}
		});
	}

	@Override
	public List<Notification> groupList(int teacherID) {
		String sql = "select * from notification where teacherID=?"+teacherID;
		return jdbcTemplate.query(sql, new RowMapper<Notification>() {
			@Override
			public Notification mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Notification(rs.getInt("notificationID"), rs.getInt("teacherID"), rs.getString("notificationTitle"),
						rs.getString("notificationContent"), rs.getDate("notificationDate"));
			}
		});
	}

}