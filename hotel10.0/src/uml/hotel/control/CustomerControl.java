package uml.hotel.control;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import uml.hotel.hibernate.HibernateSessionFactory;
import uml.hotel.dao.UmlCustomerDAO;
import uml.hotel.model.UmlCustomer;
import uml.hotel.model.UmlStatus;
import uml.hotel.model.UmlVip;
public class CustomerControl {

	/*	CustomerControl 唯一实例
	 *  仿HibernateSessionFactory设计
	 */
	private static CustomerControl control = null; 
	public static CustomerControl getCustomerControl(){
		if(null==control){
			control = new CustomerControl();
		}
		return control;
	}
	
	/* CustomerDAO
	 * CustomerlevelDAO
	 * HibernateSession
	 */
	private UmlCustomerDAO umlcustomerDao = null;
	private Session session = null;
	private CustomerControl(){
		umlcustomerDao = new UmlCustomerDAO();
		session = HibernateSessionFactory.getSession();
	}
	
	/* 类方法
	 *
	 */
	public UmlCustomer saveCustomer(String cusName, String cusPhone, String cusId,
			String sex, String cusPwd, Integer statusId, Integer vipId){
		UmlCustomer customer = new UmlCustomer(cusName, cusPhone,  cusId,
				 sex, cusPwd,  statusId, vipId);
		umlcustomerDao.save(customer);
		session.flush();
		return customer;
	}
	public UmlCustomer deleteCustomer(String str){
		UmlCustomer Customer = new UmlCustomer();
		List list = umlcustomerDao.findByCusId(str);
		umlcustomerDao.delete( ( (UmlCustomer)list.get(0)));
		umlcustomerDao.delete(Customer);
		session.flush();
		return Customer;
	}
	public List findCustomer(String CusID){
		List list = new UmlCustomerDAO().findByCusId(CusID);
		session.flush();
		return list;
	}
}