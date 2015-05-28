package uml.hotel.control;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import uml.hotel.hibernate.HibernateSessionFactory;
import uml.hotel.dao.UmlRoomDAO;
import uml.hotel.model.UmlRoom;
import uml.hotel.model.UmlRoomtype;
public class RoomControl {

	/*	RoomControl 唯一实例
	 *  仿HibernateSessionFactory设计
	 */
	private static RoomControl control = null; 
	public static RoomControl getRoomControl(){
		if(null==control){
			control = new RoomControl();
		}
		return control;
	}
	
	/* RoomDAO
	 * RoomlevelDAO
	 * HibernateSession
	 */
	private UmlRoomDAO umlroomDao = null;
	private Session session = null;
	private RoomControl(){
		umlroomDao = new UmlRoomDAO();
		session = HibernateSessionFactory.getSession();
	}
	
	/* 类方法
	 *
	 */
	public UmlRoom saveRoom(Integer roomId, Integer typeId, Integer idLodge){
		UmlRoom room = new UmlRoom( roomId,  typeId,  idLodge);
		umlroomDao.save(room);
		session.flush();
		return room;
	}
	public UmlRoom deleteroom(Integer roomId){
		UmlRoom room = new UmlRoom();
		List list = umlroomDao.findByRoomId(roomId);
		umlroomDao.delete( ( (UmlRoom)list.get(0)));
		umlroomDao.delete(room);
		session.flush();
		return room;
	}
	public List findRoom(Integer roomId){
		List list = new UmlRoomDAO().findByRoomId(roomId);
		session.flush();
		return list;
	}
}