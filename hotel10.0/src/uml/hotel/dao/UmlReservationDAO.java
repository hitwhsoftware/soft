package uml.hotel.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uml.hotel.model.UmlReservation;

/**
 * A data access object (DAO) providing persistence and search support for
 * UmlReservation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see uml.hotel.dao.UmlReservation
 * @author MyEclipse Persistence Tools
 */
public class UmlReservationDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UmlReservationDAO.class);
	// property constants
	public static final String RESER_ID = "reserId";
	public static final String ROOM_ID = "roomId";
	public static final String CUS_PHONE = "cusPhone";
	public static final String IS_SETTLE = "isSettle";
	public static final String REMARK = "remark";

	public void save(UmlReservation transientInstance) {
		Transaction transaction = getSession().beginTransaction();
		log.debug("saving UmlReservation instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public void delete(UmlReservation persistentInstance) {
		Transaction transaction = getSession().beginTransaction();
		log.debug("deleting UmlReservation instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public UmlReservation findById(java.lang.Integer id) {
		log.debug("getting UmlReservation instance with id: " + id);
		try {
			UmlReservation instance = (UmlReservation) getSession().get(
					"uml.hotel.dao.UmlReservation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UmlReservation instance) {
		log.debug("finding UmlReservation instance by example");
		try {
			List results = getSession()
					.createCriteria("uml.hotel.dao.UmlReservation")
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
		log.debug("finding UmlReservation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from UmlReservation as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByReserId(Object reserId) {
		return findByProperty(RESER_ID, reserId);
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
		log.debug("finding all UmlReservation instances");
		try {
			String queryString = "from UmlReservation";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UmlReservation merge(UmlReservation detachedInstance) {
		log.debug("merging UmlReservation instance");
		try {
			UmlReservation result = (UmlReservation) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UmlReservation instance) {
		log.debug("attaching dirty UmlReservation instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UmlReservation instance) {
		log.debug("attaching clean UmlReservation instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}