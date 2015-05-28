package uml.hotel.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uml.hotel.model.UmlVip;

/**
 * A data access object (DAO) providing persistence and search support for
 * UmlVip entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see uml.hotel.dao.UmlVip
 * @author MyEclipse Persistence Tools
 */
public class UmlVipDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(UmlVipDAO.class);
	// property constants
	public static final String VIP_ID = "vipId";
	public static final String VIP_NAME = "vipName";
	public static final String DISCOUNT = "discount";

	public void save(UmlVip transientInstance) {
		Transaction transaction = getSession().beginTransaction();
		log.debug("saving UmlVip instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public void delete(UmlVip persistentInstance) {
		Transaction transaction = getSession().beginTransaction();
		log.debug("deleting UmlVip instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public UmlVip findById(java.lang.Integer id) {
		log.debug("getting UmlVip instance with id: " + id);
		try {
			UmlVip instance = (UmlVip) getSession().get("uml.hotel.dao.UmlVip",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UmlVip instance) {
		log.debug("finding UmlVip instance by example");
		try {
			List results = getSession().createCriteria("uml.hotel.dao.UmlVip")
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
		log.debug("finding UmlVip instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UmlVip as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByVipId(Object vipId) {
		return findByProperty(VIP_ID, vipId);
	}

	public List findByVipName(Object vipName) {
		return findByProperty(VIP_NAME, vipName);
	}

	public List findByDiscount(Object discount) {
		return findByProperty(DISCOUNT, discount);
	}

	public List findAll() {
		log.debug("finding all UmlVip instances");
		try {
			String queryString = "from UmlVip";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UmlVip merge(UmlVip detachedInstance) {
		log.debug("merging UmlVip instance");
		try {
			UmlVip result = (UmlVip) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UmlVip instance) {
		log.debug("attaching dirty UmlVip instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UmlVip instance) {
		log.debug("attaching clean UmlVip instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}