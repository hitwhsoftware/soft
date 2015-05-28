package uml.hotel.control;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import uml.hotel.hibernate.HibernateSessionFactory;
import uml.hotel.dao.UmlGoodsDAO;
import uml.hotel.model.UmlGoods;
public class GoodsControl {

	/*	GoodsControl 唯一实例
	 *  仿HibernateSessionFactory设计
	 */
	private static GoodsControl control = null; 
	public static GoodsControl getGoodsControl(){
		if(null==control){
			control = new GoodsControl();
		}
		return control;
	}
	
	/* GoodsDAO
	 * GoodslevelDAO
	 * HibernateSession
	 */
	private UmlGoodsDAO umlgoodsDao = null;
	private Session session = null;
	public GoodsControl(){
		umlgoodsDao = new UmlGoodsDAO();
		session = HibernateSessionFactory.getSession();
	}
	
	/* 类方法
	 *
	 */
	public UmlGoods saveGoods(Integer goodId, String goodName, Float goodPrice,
			Integer goodNum){
		UmlGoods goods = new UmlGoods(  goodId, goodName,  goodPrice,
				 goodNum);
		umlgoodsDao.save(goods);
		session.flush();
		return goods;
	}
	public UmlGoods deleteGoods(Integer GoodsId){
		UmlGoods Goods = new UmlGoods();
		List list = umlgoodsDao.findByGoodId(GoodsId);
		umlgoodsDao.delete( ( (UmlGoods)list.get(0)));
		umlgoodsDao.delete(Goods);
		session.flush();
		return Goods;
	}
	public List findGoods(Integer goodId){
		List list = new UmlGoodsDAO().findByGoodId(goodId);
		session.flush();
		return list;
	}
}