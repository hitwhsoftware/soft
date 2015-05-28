package uml.hotel.control;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import uml.hotel.hibernate.HibernateSessionFactory;
import uml.hotel.dao.UmlStatusDAO;
import uml.hotel.model.UmlStatus;
public class StatusControl {

	/*	StatusControl 唯一实例
	 *  仿HibernateSessionFactory设计
	 */
	private static StatusControl control = null; 
	public static StatusControl getStatusControl(){
		if(null==control){
			control = new StatusControl();
		}
		return control;
	}
	
	/* StatusDAO
	 * StatuslevelDAO
	 * HibernateSession
	 */
	private UmlStatusDAO umlstatusDao = null;
	private Session session = null;
	private StatusControl(){
		umlstatusDao = new UmlStatusDAO();
		session = HibernateSessionFactory.getSession();
	}
	
	/* 类方法
	 *
	 */
	public UmlStatus saveStatus(Integer statusId, String statusName){
		UmlStatus status = new UmlStatus(  statusId,  statusName);
		umlstatusDao.save(status);
		session.flush();
		return status;
	}
	public UmlStatus deletestatus(Integer statusId){
		UmlStatus status = new UmlStatus();
		List list = umlstatusDao.findByStatusId(statusId);
		umlstatusDao.delete( ( (UmlStatus)list.get(0)));
		umlstatusDao.delete(status);
		session.flush();
		return status;
	}
	public List findStatus(Integer statusId){
		List list = new UmlStatusDAO().findByStatusName(statusId);
		session.flush();
		return list;
	}
}