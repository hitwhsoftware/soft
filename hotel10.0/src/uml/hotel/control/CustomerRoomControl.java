package uml.hotel.control;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import uml.hotel.hibernate.HibernateSessionFactory;
import uml.hotel.dao.UmlCustomerRoomDAO;
import uml.hotel.model.UmlCustomer;
import uml.hotel.model.UmlCustomerRoom;
import uml.hotel.model.UmlRoom;
public class CustomerRoomControl {

	/*	CustomerRoomControl 唯一实例
	 *  仿HibernateSessionFactory设计
	 */
	private static CustomerRoomControl control = null; 
	public static CustomerRoomControl getCustomerRoomControl(){
		if(null==control){
			control = new CustomerRoomControl();
		}
		return control;
	}
	
	/* CustomerRoomDAO
	 * CustomerRoomlevelDAO
	 * HibernateSession
	 */
	private UmlCustomerRoomDAO umlcustomerRoomDao = null;
	private Session session = null;
	private CustomerRoomControl(){
		umlcustomerRoomDao = new UmlCustomerRoomDAO();
		session = HibernateSessionFactory.getSession();
	}
	
	/* 类方法
	 *
	 */
	public UmlCustomerRoom saveCustomerRoom(Integer bookId, Integer roomId, String cusPhone,
			Timestamp startTime, Timestamp endTime, Integer isSettle,
			String remark){
		UmlCustomerRoom customerRoom = new UmlCustomerRoom(  bookId,  roomId, cusPhone,
				 startTime,  endTime,  isSettle,
				 remark);
		umlcustomerRoomDao.save(customerRoom);
		session.flush();
		return customerRoom;
	}
	public UmlCustomerRoom deleteCustomerRoom(Integer customerRoomId){
		UmlCustomerRoom CustomerRoom = new UmlCustomerRoom();
		List list = umlcustomerRoomDao.findByRoomId(customerRoomId);
		umlcustomerRoomDao.delete( ( (UmlCustomerRoom)list.get(0)));
		umlcustomerRoomDao.delete(CustomerRoom);
		session.flush();
		return CustomerRoom;
	}
	public List findCustomerRoom(Integer bookId){
		List list = new UmlCustomerRoomDAO().findByRoomId(bookId);
		session.flush();
		return list;
	}
}