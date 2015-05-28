package soft.room.control;

import java.util.List;

import soft.room.dao.ClassroomDAO;
import soft.room.dao.ClassroomstatusDAO;
import soft.room.model.Classroom;
import soft.room.model.Classroomstatus;

public class ClassroomControl {
	/*
	 * ClassroomControl唯一实例
	 */
	private static ClassroomControl classroomControl = null;
	public static ClassroomControl getClassroomControl(){
		if(null == classroomControl)
		{
			classroomControl = new ClassroomControl();
		}
		return classroomControl;
	}
	
	private ClassroomDAO classroomDao       = null;
	private ClassroomstatusDAO classroomStatusDao = null;
	private ClassroomControl(){
		classroomDao       = new ClassroomDAO();
		classroomStatusDao = new ClassroomstatusDAO();
	}
	
	/*
	 * 教室信息登记
	 */
	public void saveClassroom(String classroomId, String classroomStatusId){
		Classroom classroom = new Classroom(classroomId,classroomStatusId);
		classroomDao.save(classroom);
	}
	
	/*
	 * 教室状态登记
	 */
	public void saveClassroomStatus(String classroomStatusId, String classroomStatus){
		Classroomstatus classroomStatu = new Classroomstatus(classroomStatusId,classroomStatus);
		classroomStatusDao.save(classroomStatu);
	}
	
	/*
	 * 显示教室状态信息
	 */
	public List getClassroomStatus(){
		List list = classroomStatusDao.findAll();
		if(list.size() < 1)
		{
			return null;
		}
		else
		{
			return list;
		}
		
	}
	
	/*
	 * 显示教室编号信息
	 */
	public List getClassroomId(){
		List list = classroomDao.findAll();
		if(list.size() < 1)
		{
			return null;
		}
		else
		{
			return list;
		}
	}

}
