package uml.hotel.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uml.hotel.model.UmlCustomer;

/**
 * A data access object (DAO) providing persistence and search support for
 * UmlCustomer entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see uml.hotel.dao.UmlCustomer
 * @author MyEclipse Persistence Tools
 */
public class UmlCustomerDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UmlCustomerDAO.class);
	// property constants
	public static final String CUS_NAME = "cusName";
	public static final String CUS_PHONE = "cusPhone";
	public static final String CUS_ID = "cusId";
	public static final String SEX = "sex";
	public static final String CUS_PWD = "cusPwd";
	public static final String STATUS_ID = "statusId";
	public static final String VIP_ID = "vipId";

	public void save(UmlCustomer transientInstance) {
		Transaction transaction = getSession().beginTransaction();
		log.debug("saving UmlCustomer instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public void delete(UmlCustomer persistentInstance) {
		Transaction transaction = getSession().beginTransaction();
		log.debug("deleting UmlCustomer instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public UmlCustomer findById(java.lang.Integer id) {
		log.debug("getting UmlCustomer instance with id: " + id);
		try {
			UmlCustomer instance = (UmlCustomer) getSession().get(
					"uml.hotel.dao.UmlCustomer", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UmlCustomer instance) {
		log.debug("finding UmlCustomer instance by example");
		try {
			List results = getSession()
					.createCriteria("uml.hotel.dao.UmlCustomer")
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
		log.debug("finding UmlCustomer instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UmlCustomer as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCusName(Object cusName) {
		return findByProperty(CUS_NAME, cusName);
	}

	public List findByCusPhone(Object cusPhone) {
		return findByProperty(CUS_PHONE, cusPhone);
	}

	public List findByCusId(Object cusId) {
		return findByProperty(CUS_ID, cusId);
	}

	public List findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List findByCusPwd(Object cusPwd) {
		return findByProperty(CUS_PWD, cusPwd);
	}

	public List findByStatusId(Object statusId) {
		return findByProperty(STATUS_ID, statusId);
	}

	public List findByVipId(Object vipId) {
		return findByProperty(VIP_ID, vipId);
	}

	public List findAll() {
		log.debug("finding all UmlCustomer instances");
		try {
			String queryString = "from UmlCustomer";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UmlCustomer merge(UmlCustomer detachedInstance) {
		log.debug("merging UmlCustomer instance");
		try {
			UmlCustomer result = (UmlCustomer) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UmlCustomer instance) {
		log.debug("attaching dirty UmlCustomer instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UmlCustomer instance) {
		log.debug("attaching clean UmlCustomer instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}