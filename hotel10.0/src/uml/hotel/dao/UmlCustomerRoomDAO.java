package uml.hotel.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uml.hotel.model.UmlCustomerRoom;

/**
 * A data access object (DAO) providing persistence and search support for
 * UmlCustomerRoom entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see uml.hotel.dao.UmlCustomerRoom
 * @author MyEclipse Persistence Tools
 */
public class UmlCustomerRoomDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UmlCustomerRoomDAO.class);
	// property constants
	public static final String BOOK_ID = "bookId";
	public static final String ROOM_ID = "roomId";
	public static final String CUS_PHONE = "cusPhone";
	public static final String IS_SETTLE = "isSettle";
	public static final String REMARK = "remark";

	public void save(UmlCustomerRoom transientInstance) {
		Transaction transaction = getSession().beginTransaction();
		log.debug("saving UmlCustomerRoom instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public void delete(UmlCustomerRoom persistentInstance) {
		Transaction transaction = getSession().beginTransaction();
		log.debug("deleting UmlCustomerRoom instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public UmlCustomerRoom findById(java.lang.Integer id) {
		log.debug("getting UmlCustomerRoom instance with id: " + id);
		try {
			UmlCustomerRoom instance = (UmlCustomerRoom) getSession().get(
					"uml.hotel.dao.UmlCustomerRoom", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UmlCustomerRoom instance) {
		log.debug("finding UmlCustomerRoom instance by example");
		try {
			List results = getSession()
					.createCriteria("uml.hotel.dao.UmlCustomerRoom")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding UmlCustomerRoom instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from UmlCustomerRoom as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByBookId(Object bookId) {
		return findByProperty(BOOK_ID, bookId);
	}

	public List findByRoomId(Object roomId) {
		return findByProperty(ROOM_ID, roomId);
	}

	public List findByCusPhone(Object cusPhone) {
		return findByProperty(CUS_PHONE, cusPhone);
	}

	public List findByIsSettle(Object isSettle) {
		return findByProperty(IS_SETTLE, isSettle);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all UmlCustomerRoom instances");
		try {
			String queryString = "from UmlCustomerRoom";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UmlCustomerRoom merge(UmlCustomerRoom detachedInstance) {
		log.debug("merging UmlCustomerRoom instance");
		try {
			UmlCustomerRoom result = (UmlCustomerRoom) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UmlCustomerRoom instance) {
		log.debug("attaching dirty UmlCustomerRoom instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UmlCustomerRoom instance) {
		log.debug("attaching clean UmlCustomerRoom instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}