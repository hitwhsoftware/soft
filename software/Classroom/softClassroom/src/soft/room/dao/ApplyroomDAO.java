package soft.room.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soft.room.model.Applyroom;

/**
 * A data access object (DAO) providing persistence and search support for
 * Applyroom entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see soft.room.dao.Applyroom
 * @author MyEclipse Persistence Tools
 */
public class ApplyroomDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ApplyroomDAO.class);
	// property constants
	public static final String APPLY_ID = "applyId";
	public static final String APPLY_NAME = "applyName";
	public static final String APPLY_REASON = "applyReason";
	public static final String CLASSROOM_ID = "classroomId";
	public static final String ISDISPOSE = "isdispose";
	public static final String REMARK = "remark";

	public void save(Applyroom transientInstance) {
		log.debug("saving Applyroom instance");
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

	public void delete(Applyroom persistentInstance) {
		log.debug("deleting Applyroom instance");
		Transaction transaction = getSession().beginTransaction();
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
		transaction.commit();
		getSession().flush();
	}

	public Applyroom findById(java.lang.Integer id) {
		log.debug("getting Applyroom instance with id: " + id);
		try {
			Applyroom instance = (Applyroom) getSession().get(
					"soft.room.dao.Applyroom", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Applyroom instance) {
		log.debug("finding Applyroom instance by example");
		try {
			List results = getSession()
					.createCriteria("soft.room.dao.Applyroom")
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
		log.debug("finding Applyroom instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Applyroom as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByApplyId(Object applyId) {
		return findByProperty(APPLY_ID, applyId);
	}

	public List findByApplyName(Object applyName) {
		return findByProperty(APPLY_NAME, applyName);
	}

	public List findByApplyReason(Object applyReason) {
		return findByProperty(APPLY_REASON, applyReason);
	}

	public List findByClassroomId(Object classroomId) {
		return findByProperty(CLASSROOM_ID, classroomId);
	}

	public List findByIsdispose(Object isdispose) {
		return findByProperty(ISDISPOSE, isdispose);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all Applyroom instances");
		try {
			String queryString = "from Applyroom";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Applyroom merge(Applyroom detachedInstance) {
		log.debug("merging Applyroom instance");
		try {
			Applyroom result = (Applyroom) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Applyroom instance) {
		log.debug("attaching dirty Applyroom instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Applyroom instance) {
		log.debug("attaching clean Applyroom instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}