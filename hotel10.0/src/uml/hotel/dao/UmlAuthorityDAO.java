package uml.hotel.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uml.hotel.model.UmlAuthority;

/**
 * A data access object (DAO) providing persistence and search support for
 * UmlAuthority entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see uml.hotel.dao.UmlAuthority
 * @author MyEclipse Persistence Tools
 */
public class UmlAuthorityDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UmlAuthorityDAO.class);
	// property constants
	public static final String AUTH_ID = "authId";
	public static final String AUTH_CLASS = "authClass";

	public void save(UmlAuthority transientInstance) {
		Transaction transaction = getSession().beginTransaction();
		log.debug("saving UmlAuthority instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public void delete(UmlAuthority persistentInstance) {
		Transaction transaction = getSession().beginTransaction();
		log.debug("deleting UmlAuthority instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public UmlAuthority findById(java.lang.Integer id) {
		log.debug("getting UmlAuthority instance with id: " + id);
		try {
			UmlAuthority instance = (UmlAuthority) getSession().get(
					"uml.hotel.dao.UmlAuthority", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UmlAuthority instance) {
		log.debug("finding UmlAuthority instance by example");
		try {
			List results = getSession()
					.createCriteria("uml.hotel.dao.UmlAuthority")
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
		log.debug("finding UmlAuthority instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from UmlAuthority as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAuthId(Object authId) {
		return findByProperty(AUTH_ID, authId);
	}

	public List findByAuthClass(Object authClass) {
		return findByProperty(AUTH_CLASS, authClass);
	}

	public List findAll() {
		log.debug("finding all UmlAuthority instances");
		try {
			String queryString = "from UmlAuthority";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UmlAuthority merge(UmlAuthority detachedInstance) {
		log.debug("merging UmlAuthority instance");
		try {
			UmlAuthority result = (UmlAuthority) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UmlAuthority instance) {
		log.debug("attaching dirty UmlAuthority instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UmlAuthority instance) {
		log.debug("attaching clean UmlAuthority instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}