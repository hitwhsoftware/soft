package proj.dor.control;

import java.util.List;

import proj.dor.dao.CheckdormitoryDAO;
import proj.dor.dao.DormitoryDAO;
import proj.dor.model.Checkdormitory;

public class checkDomitoryControl {
	/*
	 * checkDomitoryControlÎ¨Ò»ÊµÀý
	 */
	private static checkDomitoryControl checkDomitory = null;
	public static checkDomitoryControl getCheckDomitory(){
		if( null == checkDomitory )
		{
			checkDomitory = new checkDomitoryControl();
		}
		return checkDomitory;
	}
	
	private CheckdormitoryDAO checkDomitoryDao = null;
	private DormitoryDAO     dormitoryDao     = null;
	
	private checkDomitoryControl(){
		checkDomitoryDao = new CheckdormitoryDAO();
		dormitoryDao     = new DormitoryDAO();
	}
	
	public boolean saveCheckDormitory(String dorId, String isquilt, String isgarbage,
			String isdesk, String isbalcony, String checkDate, String score,
			String remark){
		List list = dormitoryDao.findByDorId(dorId);
		if(list.size() < 1)
		{
			return false;
		}
		{
			Checkdormitory checkDormitory = new Checkdormitory(dorId, isquilt, isgarbage, isdesk, isbalcony, checkDate, score,remark);
			checkDomitoryDao.save(checkDormitory);
			return true;
		}
		
	}
	public List findAllCheck()
	{
		List list = checkDomitoryDao.findAll();
		return list;
	}
	public List findDormitory(String dorId){
		List list = checkDomitoryDao.findByDorId(dorId);
		return list;
	}

}
