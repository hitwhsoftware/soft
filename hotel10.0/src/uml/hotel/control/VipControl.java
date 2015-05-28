package uml.hotel.control;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import uml.hotel.hibernate.HibernateSessionFactory;
import uml.hotel.dao.UmlVipDAO;
import uml.hotel.model.UmlVip;
public class VipControl {

	/*	VipControl 唯一实例
	 *  仿HibernateSessionFactory设计
	 */
	private static VipControl control = null; 
	public static VipControl getVipControl(){
		if(null==control){
			control = new VipControl();
		}
		return control;
	}
	
	/* VipDAO
	 * ViplevelDAO
	 * HibernateSession
	 */
	private UmlVipDAO umlvipDao = null;
	private Session session = null;
	private VipControl(){
		umlvipDao = new UmlVipDAO();
		session = HibernateSessionFactory.getSession();
	}
	
	/* 类方法
	 *
	 */
	public UmlVip saveVip(Integer vipId, String vipName, Float discount){
		UmlVip vip = new UmlVip( vipId,  vipName, discount);
		umlvipDao.save(vip);
		session.flush();
		return vip;
	}
	public UmlVip deletevip(Integer vipId){
		UmlVip vip = new UmlVip();
		List list = umlvipDao.findByVipId(vipId);
		umlvipDao.delete( ( (UmlVip)list.get(0)));
		umlvipDao.delete(vip);
		session.flush();
		return vip;
	}
	public List findVip(Integer vipId){
		List list = new UmlVipDAO().findByVipName(vipId);
		session.flush();
		return list;
	}
}