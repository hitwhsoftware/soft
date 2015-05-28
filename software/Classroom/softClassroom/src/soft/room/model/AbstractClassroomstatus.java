package soft.room.model;

/**
 * AbstractClassroomstatus entity provides the base persistence definition of
 * the Classroomstatus entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractClassroomstatus implements java.io.Serializable {

	// Fields

	private Integer sid;
	private String classroomStatusId;
	private String classroomStatus;

	// Constructors

	/** default constructor */
	public AbstractClassroomstatus() {
	}

	/** full constructor */
	public AbstractClassroomstatus(String classroomStatusId,
			String classroomStatus) {
		this.classroomStatusId = classroomStatusId;
		this.classroomStatus = classroomStatus;
	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getClassroomStatusId() {
		return this.classroomStatusId;
	}

	public void setClassroomStatusId(String classroomStatusId) {
		this.classroomStatusId = classroomStatusId;
	}

	public String getClassroomStatus() {
		return this.classroomStatus;
	}

	public void setClassroomStatus(String classroomStatus) {
		this.classroomStatus = classroomStatus;
	}

}