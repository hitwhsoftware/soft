package uml.hotel.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uml.hotel.model.UmlRoomChange;

/**
 * A data access object (DAO) providing persistence and search support for
 * UmlRoomChange entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see uml.hotel.dao.UmlRoomChange
 * @author MyEclipse Persistence Tools
 */
public class UmlRoomChangeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UmlRoomChangeDAO.class);
	// property constants
	public static final String CHANGE_ID = "changeId";
	public static final String CUS_PHONE = "cusPhone";
	public static final String NEW_ROOM_ID = "newRoomId";
	public static final String TOTAL_COST = "totalCost";
	public static final String IS_SETTLE = "isSettle";
	public static final String REMARK = "remark";

	public void save(UmlRoomChange transientInstance) {
		Transaction transaction = getSession().beginTransaction();
		log.debug("saving UmlRoomChange instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public void delete(UmlRoomChange persistentInstance) {
		Transaction transaction = getSession().beginTransaction();
		log.debug("deleting UmlRoomChange instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public UmlRoomChange findById(java.lang.Integer id) {
		log.debug("getting UmlRoomChange instance with id: " + id);
		try {
			UmlRoomChange instance = (UmlRoomChange) getSession().get(
					"uml.hotel.dao.UmlRoomChange", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UmlRoomChange instance) {
		log.debug("finding UmlRoomChange instance by example");
		try {
			List results = getSession()
					.createCriteria("uml.hotel.dao.UmlRoomChange")
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
		log.debug("finding UmlRoomChange instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from UmlRoomChange as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByChangeId(Object changeId) {
		return findByProperty(CHANGE_ID, changeId);
	}

	public List findByCusPhone(Object cusPhone) {
		return findByProperty(CUS_PHONE, cusPhone);
	}

	public List findByNewRoomId(Object newRoomId) {
		return findByProperty(NEW_ROOM_ID, newRoomId);
	}

	public List findByTotalCost(Object totalCost) {
		return findByProperty(TOTAL_COST, totalCost);
	}

	public List findByIsSettle(Object isSettle) {
		return findByProperty(IS_SETTLE, isSettle);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all UmlRoomChange instances");
		try {
			String queryString = "from UmlRoomChange";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UmlRoomChange merge(UmlRoomChange detachedInstance) {
		log.debug("merging UmlRoomChange instance");
		try {
			UmlRoomChange result = (UmlRoomChange) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UmlRoomChange instance) {
		log.debug("attaching dirty UmlRoomChange instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UmlRoomChange instance) {
		log.debug("attaching clean UmlRoomChange instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}