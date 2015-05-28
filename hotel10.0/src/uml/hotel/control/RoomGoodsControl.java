package uml.hotel.control;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import uml.hotel.hibernate.HibernateSessionFactory;
import uml.hotel.dao.UmlRoomGoodsDAO;
import uml.hotel.model.UmlGoods;
import uml.hotel.model.UmlRoom;
import uml.hotel.model.UmlRoomGoods;
public class RoomGoodsControl {

	/*	RoomGoodsControl 唯一实例
	 *  仿HibernateSessionFactory设计
	 */
	private static RoomGoodsControl control = null; 
	public static RoomGoodsControl getRoomGoodsControl(){
		if(null==control){
			control = new RoomGoodsControl();
		}
		return control;
	}
	
	/* RoomGoodsDAO
	 * RoomGoodslevelDAO
	 * HibernateSession
	 */
	private UmlRoomGoodsDAO umlroomGoodsDao = null;
	private Session session = null;
	private RoomGoodsControl(){
		umlroomGoodsDao = new UmlRoomGoodsDAO();
		session = HibernateSessionFactory.getSession();
	}
	
	/* 类方法
	 *
	 */
	public UmlRoomGoods saveRoomGoods(Integer costId, Integer roomId, Integer goodId,
			Integer goodNum, Integer isSettle, String remark){
		UmlRoomGoods RoomGoods = new UmlRoomGoods( costId, roomId, goodId,
				 goodNum, isSettle,remark);
		umlroomGoodsDao.save(RoomGoods);
		session.flush();
		return RoomGoods;
	}
	public UmlRoomGoods deleteroomGoods(Integer roomId){
		UmlRoomGoods roomGoods = new UmlRoomGoods();
		List list = umlroomGoodsDao.findByRoomId(roomId);
		umlroomGoodsDao.delete( ( (UmlRoomGoods)list.get(0)));
		umlroomGoodsDao.delete(roomGoods);
		session.flush();
		return roomGoods;
	}
	public List findRoomGoods(Integer costId){
		List list = new UmlRoomGoodsDAO().findByRoomId(costId);
		session.flush();
		return list;
	}
}