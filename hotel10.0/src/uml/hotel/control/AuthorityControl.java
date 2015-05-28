package uml.hotel.control;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import uml.hotel.hibernate.HibernateSessionFactory;
import uml.hotel.dao.UmlAuthorityDAO;
import uml.hotel.model.UmlAdmin;
import uml.hotel.model.UmlAuthority;
public class AuthorityControl {

	/*	AuthorityControl 唯一实例
	 *  仿HibernateSessionFactory设计
	 */
	private static AuthorityControl control = null; 
	public static AuthorityControl getAuthorityControl(){
		if(null==control){
			control = new AuthorityControl();
		}
		return control;
	}
	
	/* AuthorityDAO
	 * AuthoritylevelDAO
	 * HibernateSession
	 */
	private UmlAuthorityDAO umlauthorityDao = null;
	private Session session = null;
	private AuthorityControl(){
		umlauthorityDao = new UmlAuthorityDAO();
		session = HibernateSessionFactory.getSession();
	}
	
	/* 类方法
	 *
	 */
	public UmlAuthority saveAuthority(Integer authId, String authClass){
		UmlAuthority authority = new UmlAuthority( authId,authClass);
		umlauthorityDao.save(authority);
		session.flush();
		return authority;
	}
	public UmlAuthority deleteAuthority(Integer authorityId){
		UmlAuthority Authority = new UmlAuthority();
		List list = umlauthorityDao.findByAuthId(authorityId);
		umlauthorityDao.delete( ( (UmlAuthority)list.get(0)));
		umlauthorityDao.delete(Authority);
		session.flush();
		return Authority;
	}
	public List findAuthority(Integer AuthClass){
		List list = new UmlAuthorityDAO().findByAuthClass(AuthClass);
		session.flush();
		return list;
	}
}