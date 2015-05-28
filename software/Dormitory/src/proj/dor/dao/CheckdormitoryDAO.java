package proj.dor.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import proj.dor.model.Checkdormitory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Checkdormitory entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see proj.dor.dao.Checkdormitory
 * @author MyEclipse Persistence Tools
 */
public class CheckdormitoryDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CheckdormitoryDAO.class);
	// property constants
	public static final String DOR_ID = "dorId";
	public static final String ISQUILT = "isquilt";
	public static final String ISGARBAGE = "isgarbage";
	public static final String ISDESK = "isdesk";
	public static final String ISBALCONY = "isbalcony";
	public static final String CHECK_DATE = "checkDate";
	public static final String SCORE = "score";
	public static final String REMARK = "remark";

	public void save(Checkdormitory transientInstance) {
		log.debug("saving Checkdormitory instance");
		Transaction transaction = getSession().beginTransaction();
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		transaction.commit();
		getSession().flush();
	}

	public void delete(Checkdormitory persistentInstance) {
		log.debug("deleting Checkdormitory instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Checkdormitory findById(java.lang.Integer id) {
		log.debug("getting Checkdormitory instance with id: " + id);
		try {
			Checkdormitory instance = (Checkdormitory) getSession().get(
					"proj.dor.dao.Checkdormitory", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Checkdormitory instance) {
		log.debug("finding Checkdormitory instance by example");
		try {
			List results = getSession()
					.createCriteria("proj.dor.dao.Checkdormitory")
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
		log.debug("finding Checkdormitory instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Checkdormitory as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDorId(Object dorId) {
		return findByProperty(DOR_ID, dorId);
	}

	public List findByIsquilt(Object isquilt) {
		return findByProperty(ISQUILT, isquilt);
	}

	public List findByIsgarbage(Object isgarbage) {
		return findByProperty(ISGARBAGE, isgarbage);
	}

	public List findByIsdesk(Object isdesk) {
		return findByProperty(ISDESK, isdesk);
	}

	public List findByIsbalcony(Object isbalcony) {
		return findByProperty(ISBALCONY, isbalcony);
	}

	public List findByCheckDate(Object checkDate) {
		return findByProperty(CHECK_DATE, checkDate);
	}

	public List findByScore(Object score) {
		return findByProperty(SCORE, score);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all Checkdormitory instances");
		try {
			String queryString = "from Checkdormitory";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Checkdormitory merge(Checkdormitory detachedInstance) {
		log.debug("merging Checkdormitory instance");
		try {
			Checkdormitory result = (Checkdormitory) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Checkdormitory instance) {
		log.debug("attaching dirty Checkdormitory instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Checkdormitory instance) {
		log.debug("attaching clean Checkdormitory instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}