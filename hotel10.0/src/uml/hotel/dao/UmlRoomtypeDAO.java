package uml.hotel.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uml.hotel.model.UmlRoomtype;

/**
 * A data access object (DAO) providing persistence and search support for
 * UmlRoomtype entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see uml.hotel.dao.UmlRoomtype
 * @author MyEclipse Persistence Tools
 */
public class UmlRoomtypeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UmlRoomtypeDAO.class);
	// property constants
	public static final String TYPE_ID = "typeId";
	public static final String ROOM_TYPE = "roomType";
	public static final String ROOM_PRICE = "roomPrice";

	public void save(UmlRoomtype transientInstance) {
		Transaction transaction = getSession().beginTransaction();
		log.debug("saving UmlRoomtype instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public void delete(UmlRoomtype persistentInstance) {
		Transaction transaction = getSession().beginTransaction();
		log.debug("deleting UmlRoomtype instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public UmlRoomtype findById(java.lang.Integer id) {
		log.debug("getting UmlRoomtype instance with id: " + id);
		try {
			UmlRoomtype instance = (UmlRoomtype) getSession().get(
					"uml.hotel.dao.UmlRoomtype", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UmlRoomtype instance) {
		log.debug("finding UmlRoomtype instance by example");
		try {
			List results = getSession()
					.createCriteria("uml.hotel.dao.UmlRoomtype")
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
		log.debug("finding UmlRoomtype instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UmlRoomtype as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTypeId(Object typeId) {
		return findByProperty(TYPE_ID, typeId);
	}

	public List findByRoomType(Object roomType) {
		return findByProperty(ROOM_TYPE, roomType);
	}

	public List findByRoomPrice(Object roomPrice) {
		return findByProperty(ROOM_PRICE, roomPrice);
	}

	public List findAll() {
		log.debug("finding all UmlRoomtype instances");
		try {
			String queryString = "from UmlRoomtype";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UmlRoomtype merge(UmlRoomtype detachedInstance) {
		log.debug("merging UmlRoomtype instance");
		try {
			UmlRoomtype result = (UmlRoomtype) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UmlRoomtype instance) {
		log.debug("attaching dirty UmlRoomtype instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UmlRoomtype instance) {
		log.debug("attaching clean UmlRoomtype instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}