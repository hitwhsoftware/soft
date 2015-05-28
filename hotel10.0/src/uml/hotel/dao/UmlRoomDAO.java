package uml.hotel.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uml.hotel.model.UmlRoom;

/**
 * A data access object (DAO) providing persistence and search support for
 * UmlRoom entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see uml.hotel.dao.UmlRoom
 * @author MyEclipse Persistence Tools
 */
public class UmlRoomDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(UmlRoomDAO.class);
	// property constants
	public static final String ROOM_ID = "roomId";
	public static final String TYPE_ID = "typeId";
	public static final String IS_LODGE = "isLodge";

	public void save(UmlRoom transientInstance) {
		Transaction transaction = getSession().beginTransaction();
		log.debug("saving UmlRoom instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public void delete(UmlRoom persistentInstance) {
		Transaction transaction = getSession().beginTransaction();
		log.debug("deleting UmlRoom instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public UmlRoom findById(java.lang.Integer id) {
		log.debug("getting UmlRoom instance with id: " + id);
		try {
			UmlRoom instance = (UmlRoom) getSession().get(
					"uml.hotel.dao.UmlRoom", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UmlRoom instance) {
		log.debug("finding UmlRoom instance by example");
		try {
			List results = getSession().createCriteria("uml.hotel.dao.UmlRoom")
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
		log.debug("finding UmlRoom instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UmlRoom as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByRoomId(Object roomId) {
		return findByProperty(ROOM_ID, roomId);
	}

	public List findByTypeId(Object typeId) {
		return findByProperty(TYPE_ID, typeId);
	}

	public List findByIsLodge(Object isLodge) {
		return findByProperty(IS_LODGE, isLodge);
	}

	public List findAll() {
		log.debug("finding all UmlRoom instances");
		try {
			String queryString = "from UmlRoom";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UmlRoom merge(UmlRoom detachedInstance) {
		log.debug("merging UmlRoom instance");
		try {
			UmlRoom result = (UmlRoom) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UmlRoom instance) {
		log.debug("attaching dirty UmlRoom instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UmlRoom instance) {
		log.debug("attaching clean UmlRoom instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}