package uml.hotel.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uml.hotel.model.UmlRoomGoods;

/**
 * A data access object (DAO) providing persistence and search support for
 * UmlRoomGoods entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see uml.hotel.dao.UmlRoomGoods
 * @author MyEclipse Persistence Tools
 */
public class UmlRoomGoodsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UmlRoomGoodsDAO.class);
	// property constants
	public static final String COST_ID = "costId";
	public static final String ROOM_ID = "roomId";
	public static final String GOOD_ID = "goodId";
	public static final String GOOD_NUM = "goodNum";
	public static final String IS_SETTLE = "isSettle";
	public static final String REMARK = "remark";

	public void save(UmlRoomGoods transientInstance) {
		Transaction transaction = getSession().beginTransaction();
		log.debug("saving UmlRoomGoods instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public void delete(UmlRoomGoods persistentInstance) {
		Transaction transaction = getSession().beginTransaction();
		log.debug("deleting UmlRoomGoods instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public UmlRoomGoods findById(java.lang.Integer id) {
		log.debug("getting UmlRoomGoods instance with id: " + id);
		try {
			UmlRoomGoods instance = (UmlRoomGoods) getSession().get(
					"uml.hotel.dao.UmlRoomGoods", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UmlRoomGoods instance) {
		log.debug("finding UmlRoomGoods instance by example");
		try {
			List results = getSession()
					.createCriteria("uml.hotel.dao.UmlRoomGoods")
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
		log.debug("finding UmlRoomGoods instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from UmlRoomGoods as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCostId(Object costId) {
		return findByProperty(COST_ID, costId);
	}

	public List findByRoomId(Object roomId) {
		return findByProperty(ROOM_ID, roomId);
	}

	public List findByGoodId(Object goodId) {
		return findByProperty(GOOD_ID, goodId);
	}

	public List findByGoodNum(Object goodNum) {
		return findByProperty(GOOD_NUM, goodNum);
	}

	public List findByIsSettle(Object isSettle) {
		return findByProperty(IS_SETTLE, isSettle);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all UmlRoomGoods instances");
		try {
			String queryString = "from UmlRoomGoods";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UmlRoomGoods merge(UmlRoomGoods detachedInstance) {
		log.debug("merging UmlRoomGoods instance");
		try {
			UmlRoomGoods result = (UmlRoomGoods) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UmlRoomGoods instance) {
		log.debug("attaching dirty UmlRoomGoods instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UmlRoomGoods instance) {
		log.debug("attaching clean UmlRoomGoods instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}