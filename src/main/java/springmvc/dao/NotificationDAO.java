package springmvc.dao;

import java.util.List;

import springmvc.model.Notification;

public interface NotificationDAO {
	public void create(Notification notification);

	public void update(Notification notification);

	public void delete(int notificationID);

	public List<Notification> list();
	
	public List<Notification> groupList(int teacherID);
}
