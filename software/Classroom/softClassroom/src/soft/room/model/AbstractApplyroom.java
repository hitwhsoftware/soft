package soft.room.model;

import java.sql.Timestamp;

/**
 * AbstractApplyroom entity provides the base persistence definition of the
 * Applyroom entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractApplyroom implements java.io.Serializable {

	// Fields

	private Integer aid;
	private Integer applyId;
	private String applyName;
	private Timestamp applyStartTime;
	private Timestamp applyEndTime;
	private String applyReason;
	private String classroomId;
	private Integer isdispose;
	private String remark;

	// Constructors

	/** default constructor */
	public AbstractApplyroom() {
	}

	/** minimal constructor */
	public AbstractApplyroom(Integer applyId, String applyName,
			Timestamp applyStartTime, Timestamp applyEndTime,
			String applyReason, String classroomId, Integer isdispose) {
		this.applyId = applyId;
		this.applyName = applyName;
		this.applyStartTime = applyStartTime;
		this.applyEndTime = applyEndTime;
		this.applyReason = applyReason;
		this.classroomId = classroomId;
		this.isdispose = isdispose;
	}

	/** full constructor */
	public AbstractApplyroom(Integer applyId, String applyName,
			Timestamp applyStartTime, Timestamp applyEndTime,
			String applyReason, String classroomId, Integer isdispose,
			String remark) {
		this.applyId = applyId;
		this.applyName = applyName;
		this.applyStartTime = applyStartTime;
		this.applyEndTime = applyEndTime;
		this.applyReason = applyReason;
		this.classroomId = classroomId;
		this.isdispose = isdispose;
		this.remark = remark;
	}

	// Property accessors

	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public Integer getApplyId() {
		return this.applyId;
	}

	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}

	public String getApplyName() {
		return this.applyName;
	}

	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}

	public Timestamp getApplyStartTime() {
		return this.applyStartTime;
	}

	public void setApplyStartTime(Timestamp applyStartTime) {
		this.applyStartTime = applyStartTime;
	}

	public Timestamp getApplyEndTime() {
		return this.applyEndTime;
	}

	public void setApplyEndTime(Timestamp applyEndTime) {
		this.applyEndTime = applyEndTime;
	}

	public String getApplyReason() {
		return this.applyReason;
	}

	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}

	public String getClassroomId() {
		return this.classroomId;
	}

	public void setClassroomId(String classroomId) {
		this.classroomId = classroomId;
	}

	public Integer getIsdispose() {
		return this.isdispose;
	}

	public void setIsdispose(Integer isdispose) {
		this.isdispose = isdispose;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}