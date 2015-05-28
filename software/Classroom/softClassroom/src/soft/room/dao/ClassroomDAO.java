package soft.room.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soft.room.model.Classroom;

/**
 * A data access object (DAO) providing persistence and search support for
 * Classroom entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see soft.room.dao.Classroom
 * @author MyEclipse Persistence Tools
 */
public class ClassroomDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ClassroomDAO.class);
	// property constants
	public static final String CLASSROOM_ID = "classroomId";
	public static final String CLASSROOM_STATUS_ID = "classroomStatusId";

	public void save(Classroom transientInstance) {
		log.debug("saving Classroom instance");
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

	public void delete(Classroom persistentInstance) {
		log.debug("deleting Classroom instance");
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

	public Classroom findById(java.lang.Integer id) {
		log.debug("getting Classroom instance with id: " + id);
		try {
			Classroom instance = (Classroom) getSession().get(
					"soft.room.dao.Classroom", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Classroom instance) {
		log.debug("finding Classroom instance by example");
		try {
			List results = getSession()
					.createCriteria("soft.room.dao.Classroom")
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
		log.debug("finding Classroom instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Classroom as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByClassroomId(Object classroomId) {
		return findByProperty(CLASSROOM_ID, classroomId);
	}

	public List findByClassroomStatusId(Object classroomStatusId) {
		return findByProperty(CLASSROOM_STATUS_ID, classroomStatusId);
	}

	public List findAll() {
		log.debug("finding all Classroom instances");
		try {
			String queryString = "from Classroom";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Classroom merge(Classroom detachedInstance) {
		log.debug("merging Classroom instance");
		try {
			Classroom result = (Classroom) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Classroom instance) {
		log.debug("attaching dirty Classroom instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Classroom instance) {
		log.debug("attaching clean Classroom instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}