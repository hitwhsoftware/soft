package soft.room.model;

/**
 * Classroom entity. @author MyEclipse Persistence Tools
 */
public class Classroom extends AbstractClassroom implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Classroom() {
	}

	/** full constructor */
	public Classroom(String classroomId, String classroomStatusId) {
		super(classroomId, classroomStatusId);
	}

}
