package soft.room.model;

/**
 * AbstractClassroom entity provides the base persistence definition of the
 * Classroom entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractClassroom implements java.io.Serializable {

	// Fields

	private Integer cid;
	private String classroomId;
	private String classroomStatusId;

	// Constructors

	/** default constructor */
	public AbstractClassroom() {
	}

	/** full constructor */
	public AbstractClassroom(String classroomId, String classroomStatusId) {
		this.classroomId = classroomId;
		this.classroomStatusId = classroomStatusId;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getClassroomId() {
		return this.classroomId;
	}

	public void setClassroomId(String classroomId) {
		this.classroomId = classroomId;
	}

	public String getClassroomStatusId() {
		return this.classroomStatusId;
	}

	public void setClassroomStatusId(String classroomStatusId) {
		this.classroomStatusId = classroomStatusId;
	}

}