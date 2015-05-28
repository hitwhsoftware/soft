package soft.room.model;

import java.sql.Timestamp;

/**
 * Applyroom entity. @author MyEclipse Persistence Tools
 */
public class Applyroom extends AbstractApplyroom implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Applyroom() {
	}

	/** minimal constructor */
	public Applyroom(Integer applyId, String applyName,
			Timestamp applyStartTime, Timestamp applyEndTime,
			String applyReason, String classroomId, Integer isdispose) {
		super(applyId, applyName, applyStartTime, applyEndTime, applyReason,
				classroomId, isdispose);
	}

	/** full constructor */
	public Applyroom(Integer applyId, String applyName,
			Timestamp applyStartTime, Timestamp applyEndTime,
			String applyReason, String classroomId, Integer isdispose,
			String remark) {
		super(applyId, applyName, applyStartTime, applyEndTime, applyReason,
				classroomId, isdispose, remark);
	}

}
