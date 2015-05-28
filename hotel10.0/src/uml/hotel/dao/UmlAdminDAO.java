package uml.hotel.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uml.hotel.model.UmlAdmin;

/**
 * A data access object (DAO) providing persistence and search support for
 * UmlAdmin entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see uml.hotel.dao.UmlAdmin
 * @author MyEclipse Persistence Tools
 */
public class UmlAdminDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UmlAdminDAO.class);
	// property constants
	public static final String ADMIN_NAME = "adminName";
	public static final String ADMIN_PWD = "adminPwd";
	public static final String AUTH_ID = "authId";

	public void save(UmlAdmin transientInstance) {
		Transaction transaction = getSession().beginTransaction();
		log.debug("saving UmlAdmin instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public void delete(UmlAdmin persistentInstance) {
		Transaction transaction = getSession().beginTransaction();
		log.debug("deleting UmlAdmin instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public UmlAdmin findById(java.lang.Integer id) {
		log.debug("getting UmlAdmin instance with id: " + id);
		try {
			UmlAdmin instance = (UmlAdmin) getSession().get(
					"uml.hotel.dao.UmlAdmin", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UmlAdmin instance) {
		log.debug("finding UmlAdmin instance by example");
		try {
			List results = getSession()
					.createCriteria("uml.hotel.dao.UmlAdmin")
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
		log.debug("finding UmlAdmin instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UmlAdmin as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAdminName(Object adminName) {
		return findByProperty(ADMIN_NAME, adminName);
	}

	public List findByAdminPwd(Object adminPwd) {
		return findByProperty(ADMIN_PWD, adminPwd);
	}

	public List findByAuthId(Object authId) {
		return findByProperty(AUTH_ID, authId);
	}

	public List findAll() {
		log.debug("finding all UmlAdmin instances");
		try {
			String queryString = "from UmlAdmin";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UmlAdmin merge(UmlAdmin detachedInstance) {
		log.debug("merging UmlAdmin instance");
		try {
			UmlAdmin result = (UmlAdmin) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UmlAdmin instance) {
		log.debug("attaching dirty UmlAdmin instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UmlAdmin instance) {
		log.debug("attaching clean UmlAdmin instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}