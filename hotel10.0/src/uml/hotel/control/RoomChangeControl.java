package uml.hotel.control;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import uml.hotel.hibernate.HibernateSessionFactory;
import uml.hotel.dao.UmlRoomChangeDAO;
import uml.hotel.model.UmlCustomer;
import uml.hotel.model.UmlRoom;
import uml.hotel.model.UmlRoomChange;
public class RoomChangeControl {

	/*	RoomChangeControl 唯一实例
	 *  仿HibernateSessionFactory设计
	 */
	private static RoomChangeControl control = null; 
	public static RoomChangeControl getRoomChangeControl(){
		if(null==control){
			control = new RoomChangeControl();
		}
		return control;
	}
	
	/* RoomChangeDAO
	 * RoomChangelevelDAO
	 * HibernateSession
	 */
	private UmlRoomChangeDAO umlroomChangeDao = null;
	private Session session = null;
	private RoomChangeControl(){
		umlroomChangeDao = new UmlRoomChangeDAO();
		session = HibernateSessionFactory.getSession();
	}
	
	/* 类方法
	 *
	 */
	public UmlRoomChange saveRoomChange(Integer changeId, String cusPhone, Integer newRoomId,
			Float totalCost, Timestamp startTime, Timestamp endTime,
			Integer isSettle, String remark){
		UmlRoomChange roomChange = new UmlRoomChange( changeId,  cusPhone,  newRoomId, totalCost,  startTime, endTime,isSettle,remark);
		umlroomChangeDao.save(roomChange);
		session.flush();
		return roomChange;
	}
	public UmlRoomChange deleteroomChange(Integer roomChangeId){
		UmlRoomChange roomChange = new UmlRoomChange();
		List list = umlroomChangeDao.findByChangeId(roomChangeId);
		umlroomChangeDao.delete( ( (UmlRoomChange)list.get(0)));
		umlroomChangeDao.delete(roomChange);
		session.flush();
		return roomChange;
	}
	public List findRoomChange(Integer changeId){
		List list = new UmlRoomChangeDAO().findByNewRoomId(changeId);
		session.flush();
		return list;
	}
}