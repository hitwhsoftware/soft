package uml.hotel.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uml.hotel.model.UmlGoods;

/**
 * A data access object (DAO) providing persistence and search support for
 * UmlGoods entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see uml.hotel.dao.UmlGoods
 * @author MyEclipse Persistence Tools
 */
public class UmlGoodsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UmlGoodsDAO.class);
	// property constants
	public static final String GOOD_ID = "goodId";
	public static final String GOOD_NAME = "goodName";
	public static final String GOOD_PRICE = "goodPrice";
	public static final String GOOD_NUM = "goodNum";

	public void save(UmlGoods transientInstance) {
		Transaction transaction = getSession().beginTransaction();
		log.debug("saving UmlGoods instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public void delete(UmlGoods persistentInstance) {
		Transaction transaction = getSession().beginTransaction();
		log.debug("deleting UmlGoods instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}transaction.commit();
		getSession().flush();
	}

	public UmlGoods findById(java.lang.Integer id) {
		log.debug("getting UmlGoods instance with id: " + id);
		try {
			UmlGoods instance = (UmlGoods) getSession().get(
					"uml.hotel.dao.UmlGoods", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UmlGoods instance) {
		log.debug("finding UmlGoods instance by example");
		try {
			List results = getSession()
					.createCriteria("uml.hotel.dao.UmlGoods")
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
		log.debug("finding UmlGoods instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UmlGoods as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByGoodId(Object goodId) {
		return findByProperty(GOOD_ID, goodId);
	}

	public List findByGoodName(Object goodName) {
		return findByProperty(GOOD_NAME, goodName);
	}

	public List findByGoodPrice(Object goodPrice) {
		return findByProperty(GOOD_PRICE, goodPrice);
	}

	public List findByGoodNum(Object goodNum) {
		return findByProperty(GOOD_NUM, goodNum);
	}

	public List findAll() {
		log.debug("finding all UmlGoods instances");
		try {
			String queryString = "from UmlGoods";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UmlGoods merge(UmlGoods detachedInstance) {
		log.debug("merging UmlGoods instance");
		try {
			UmlGoods result = (UmlGoods) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UmlGoods instance) {
		log.debug("attaching dirty UmlGoods instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UmlGoods instance) {
		log.debug("attaching clean UmlGoods instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}