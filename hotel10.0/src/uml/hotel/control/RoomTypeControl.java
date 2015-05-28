package uml.hotel.control;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import uml.hotel.hibernate.HibernateSessionFactory;
import uml.hotel.dao.UmlRoomtypeDAO;
import uml.hotel.model.UmlRoomtype;
public class RoomTypeControl {

	/*	RoomTypeControl 唯一实例
	 *  仿HibernateSessionFactory设计
	 */
	private static RoomTypeControl control = null; 
	public static RoomTypeControl getRoomTypeControl(){
		if(null==control){
			control = new RoomTypeControl();
		}
		return control;
	}
	
	/* RoomTypeDAO
	 * RoomTypelevelDAO
	 * HibernateSession
	 */
	private UmlRoomtypeDAO umlroomTypeDao = null;
	private Session session = null;
	private RoomTypeControl(){
		umlroomTypeDao = new UmlRoomtypeDAO();
		session = HibernateSessionFactory.getSession();
	}
	
	/* 类方法
	 *
	 */
	public UmlRoomtype saveRoomType(Integer typeId, String roomType, Float roomPrice){
		UmlRoomtype roomtype = new UmlRoomtype(typeId,  roomType,  roomPrice);
		umlroomTypeDao.save(roomtype);
		session.flush();
		return roomtype;
	}
	public UmlRoomtype deleteroomtype(Integer typeId){
		UmlRoomtype roomtype = new UmlRoomtype();
		List list = umlroomTypeDao.findByTypeId(typeId);
		umlroomTypeDao.delete( ( (UmlRoomtype)list.get(0)));
		umlroomTypeDao.delete(roomtype);
		session.flush();
		return roomtype;
	}
	public List findRoomType(Integer typeId){
		List list = new UmlRoomtypeDAO().findByRoomType(typeId);
		session.flush();
		return list;
	}
}