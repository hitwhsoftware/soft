package uml.hotel.control;
import java.sql.Timestamp;
import java.util.List;

import uml.hotel.dao.UmlReservationDAO;
import uml.hotel.dao.UmlRoomDAO;
//import umlSoftware.hotel.model.UmlCustomer;
//import umlSoftware.hotel.model.UmlCustomerRoom;
import uml.hotel.model.UmlReservation;
import uml.hotel.model.UmlRoom;
//import umlSoftware.hotel.dao.UmlCustomerDAO;
public class ReservationControl {
		/*
		 * CustomerControl唯一实例
		 * 仿HibernateSessionFactory设计
		 */
		private static ReservationControl control = null;
		public static ReservationControl getReservationControl(){
			if(null == control){
				control = new ReservationControl();
			}
			return control;
		}
		/*
		 * UmlCustomerRoomDAO
		 * UmlRoomDAO 
		 */
		private UmlReservationDAO  reservationDao  = null;
//		private UmlCustomerDAO     customerDao 	   = null;
		private UmlRoomDAO         roomDao         = null;
		
		
		private ReservationControl(){
			reservationDao = new UmlReservationDAO();
//			customerDao     = new UmlCustomerDAO();
			roomDao         = new UmlRoomDAO();
		}
		
		/*
		 * 预约
		 */
		public boolean saveReservation(Integer reserId, Integer roomId,
				String cusPhone, String rstartTime, String rendTime,
				String reserTime, String remark){
			Timestamp startTime = new Timestamp(System.currentTimeMillis());
			startTime = Timestamp.valueOf(rstartTime);
			Timestamp endTime = new Timestamp(System.currentTimeMillis());
			endTime = Timestamp.valueOf(rstartTime);
			Timestamp eserTime = new Timestamp(System.currentTimeMillis());
			eserTime = Timestamp.valueOf(rstartTime);
			
			List list = roomDao.findByRoomId(roomId);
			if(list.size() < 1)
			{
				return false;
			}else
			{
				UmlReservation reservation = new UmlReservation(reserId,roomId,cusPhone,
						startTime,endTime,eserTime,0,remark);
				reservationDao.save(reservation);
				for(int i=0; i <list.size(); i++)
				{
					((UmlRoom)list.get(i)).setIsLodge(1);
					roomDao.save((UmlRoom)list.get(i));
				}
				return true;
			}
			
		}
		
		/*
		 * 换房
		 */
		public boolean changeRoom(Integer reserID,Integer roomId){
			int oldRoomId = 0;
			List listReservation = reservationDao.findByReserId(reserID);
			for(int i = 0; i < listReservation.size(); i++)
			{
				oldRoomId = ( (UmlReservation)listReservation.get(i) ).getRoomId();
			}
			List listRoom = roomDao.findByRoomId(roomId);
			List listOldRoom = roomDao.findByRoomId(oldRoomId);
			if((listReservation.size() < 1)||(listRoom.size() < 1)||(listOldRoom.size() < 1))
			{
				return false;
			}
			else
			{
				for(int i =0; i < listReservation.size(); i++)
				{
					( (UmlReservation)listReservation.get(i) ).setRoomId(roomId);
					reservationDao.save( ((UmlReservation)listReservation.get(i)) );
					((UmlRoom)listRoom.get(i)).setIsLodge(1);
					roomDao.save((UmlRoom)listRoom.get(i));
					((UmlRoom)listOldRoom.get(i)).setIsLodge(0);
					roomDao.save((UmlRoom)listOldRoom.get(i));
				}
				return true;
			}
			
		}
		
		/*
		 * 取消订单
		 */
		public boolean cancleReser(Integer reserID){
			int roomId = 0;
			List listReservation = reservationDao.findByReserId(reserID);
			for(int i = 0; i < listReservation.size(); i++)
			{
				roomId = ( (UmlReservation)listReservation.get(i) ).getRoomId();
			}
			List listRoom = roomDao.findByRoomId(roomId);
			if((listReservation.size() < 1)||(listRoom.size() < 1))
			{
				return false;
			}
			else
			{
				for(int i =0; i < listReservation.size(); i++)
				{
					( (UmlReservation)listReservation.get(i) ).setIsSettle(1);
					reservationDao.save( ((UmlReservation)listReservation.get(i)) );
					((UmlRoom)listRoom.get(i)).setIsLodge(0);
					roomDao.save((UmlRoom)listRoom.get(i));
				}
				return true;
			}
		}
		
		/*
		 * 显示预约信息
		 */
		public List showReser(String cusPhone){
			List listReservation = reservationDao.findByCusPhone(cusPhone);
			return listReservation;
		}

	}

