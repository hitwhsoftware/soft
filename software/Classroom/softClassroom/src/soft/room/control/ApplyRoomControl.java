package soft.room.control;

import java.sql.Timestamp;
import java.util.List;

import soft.room.dao.ApplyroomDAO;
import soft.room.dao.ClassroomDAO;
import soft.room.model.Applyroom;
import soft.room.model.Classroom;


public class ApplyRoomControl {
		/*
		 * ApplayRoomControl唯一实例
		 */
		private static ApplyRoomControl applyRoomControl = null;
		public static ApplyRoomControl getApplayRoomControl(){
			if(null == applyRoomControl)
			{
				applyRoomControl = new ApplyRoomControl();
			}
			return applyRoomControl;
		}
		
		private ApplyroomDAO applyRoomDao = null;
		private ClassroomDAO classroomDao = null;
		private ApplyRoomControl(){
			applyRoomDao = new ApplyroomDAO();
			classroomDao = new ClassroomDAO();
		}
		
		/*
		 * 申请占用教室
		 */
		public boolean saveApplyRoom(Integer applyId, String applyName,
				String startTime, String endTime,
				String applyReason, String classroomId, Integer isdispose,
				String remark){
			Timestamp applyStartTime = new Timestamp(System.currentTimeMillis());
			applyStartTime = Timestamp.valueOf(startTime);
			Timestamp applyEndTime = new Timestamp(System.currentTimeMillis());
			applyStartTime = Timestamp.valueOf(endTime);
			List list = classroomDao.findByClassroomId(classroomId);
			if(list.size() < 1)
			{
				return false;
			}
			else
			{
				Applyroom applyRoom = new Applyroom(applyId,applyName,applyStartTime,applyEndTime,applyReason,
						classroomId,0,remark);
				applyRoomDao.save(applyRoom);
				for(int i = 0; i < list.size(); i++)
				{
					((Classroom)list.get(i)).setClassroomStatusId("1");
					classroomDao.save((Classroom)list.get(i));
					new Classroom();
				}
				return true;
			}
			
		}
		
		/*
		 * 取消教室占用
		 */
		public boolean CancelApply(Integer applyId){
			List list = applyRoomDao.findByApplyId(applyId);
			if(list.size() < 1)
			{
				return false;
			}
			else
			{
				for(int i = 0; i < list.size(); i++)
				{
					((Applyroom)list.get(i)).setIsdispose(1);
					applyRoomDao.save((Applyroom)list.get(i));
					List listroom = classroomDao.findByClassroomId(((Applyroom)list.get(i)).getClassroomId());
					for(int j = 0; j < list.size(); j++)
					{
						((Classroom)listroom.get(j)).setClassroomStatusId("0");
						classroomDao.save((Classroom)listroom.get(j));
					}
				}
				return true;
			}
			
		}
		
		/*
		 * 更换教室
		 */
		public boolean changeClassroom(Integer applyId, String classroomId){
			String oldRoomId = null;
			List listApply = applyRoomDao.findByApplyId(applyId);
			for(int i = 0; i < listApply.size(); i++)
			{
				oldRoomId = ( (Applyroom)listApply.get(i) ).getClassroomId();
			}
			List listRoom = classroomDao.findByClassroomId(classroomId);
			List listOldRoom = classroomDao.findByClassroomId(oldRoomId);
			if((listApply.size() < 1)||(listRoom.size() < 1)||(listOldRoom.size() < 1))
			{
				return false;
			}
			else
			{
				for(int i =0; i < listApply.size(); i++)
				{
					( (Applyroom)listApply.get(i) ).setClassroomId(classroomId);
					applyRoomDao.save( (Applyroom)listApply.get(i) );
					((Classroom)listRoom.get(i)).setClassroomStatusId("1");
					classroomDao.save((Classroom)listRoom.get(i));
					((Classroom)listOldRoom.get(i)).setClassroomStatusId("0");
					classroomDao.save((Classroom)listOldRoom.get(i));
				}
				return true;
			}
		}
		
		/*
		 * 显示当前用户申请信息
		 */
		public List currentApply(){
			List list = applyRoomDao.findByIsdispose(0);
				return list;
		}
		
		/*
		 * 显示历史申请信息
		 */
		public List historyApply(){
			List list = applyRoomDao.findByIsdispose(1);
				return list;
		}
		
		/*
		 * 显示某用户申请信息
		 */
		public List UserApply(String applyName){
			List list = applyRoomDao.findByApplyName(applyName);
				return list;
		}
		
		/*
		 * 显示所有申请信息
		 */
		public List allApply(){
			List list = applyRoomDao.findAll();
				return list;
		}

}
