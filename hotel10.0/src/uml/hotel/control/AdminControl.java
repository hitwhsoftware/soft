package uml.hotel.control;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import uml.hotel.dao.UmlAdminDAO;
import uml.hotel.model.UmlAdmin;
import uml.hotel.hibernate.HibernateSessionFactory;
import uml.hotel.dao.UmlAuthorityDAO;
import uml.hotel.model.UmlAuthority;
public class AdminControl {

	/*	AdminControl Ψһʵ��
	 *  ��HibernateSessionFactory���
	 */
	private static AdminControl control = null; 
	public static AdminControl getAdminControl(){
		if(null==control){
			control = new AdminControl();
		}
		return control;
	}
	
	/* AdminDAO
	 * AdminlevelDAO
	 * HibernateSession
	 */
	private UmlAdminDAO umladminDao = null;
	private Session session = null;
	private AdminControl(){
		umladminDao = new UmlAdminDAO();
		session = HibernateSessionFactory.getSession();
	}
	
	/* �෽��
	 *
	 */
	public UmlAdmin saveAdmin( String adminName, String adminPwd,
			Integer authId){
		UmlAdmin admin = new UmlAdmin(adminName,adminPwd,
				 authId);
		umladminDao.save(admin);
		session.flush();
		return admin;
	}
	public UmlAdmin deleteAdmin(String adminName){
		UmlAdmin admin = new UmlAdmin();
		List list = umladminDao.findByAdminName(adminName);
		umladminDao.delete( ( (UmlAdmin)list.get(0)));
		umladminDao.delete(admin);
		session.flush();
		return admin;
	}
	public List findAdmin(String AdminName){
		List list = new UmlAdminDAO().findByAdminName(AdminName);
		session.flush();
		return list;
	}
}