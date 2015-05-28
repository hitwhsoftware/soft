package uml.hotel.model;

import java.sql.Timestamp;

/**
 * UmlRoomChange entity. @author MyEclipse Persistence Tools
 */

public class UmlRoomChange implements java.io.Serializable {

	// Fields

	private Integer cgId;
	private Integer changeId;
	private String cusPhone;
	private Integer newRoomId;
	private Float totalCost;
	private Timestamp startTime;
	private Timestamp endTime;
	private Integer isSettle;
	private String remark;

	// Constructors

	/** default constructor */
	public UmlRoomChange() {
	}

	/** full constructor */
	public UmlRoomChange(Integer changeId, String cusPhone, Integer newRoomId,
			Float totalCost, Timestamp startTime, Timestamp endTime,
			Integer isSettle, String remark) {
		this.changeId = changeId;
		this.cusPhone = cusPhone;
		this.newRoomId = newRoomId;
		this.totalCost = totalCost;
		this.startTime = startTime;
		this.endTime = endTime;
		this.isSettle = isSettle;
		this.remark = remark;
	}

	// Property accessors

	public Integer getCgId() {
		return this.cgId;
	}

	public void setCgId(Integer cgId) {
		this.cgId = cgId;
	}

	public Integer getChangeId() {
		return this.changeId;
	}

	public void setChangeId(Integer changeId) {
		this.changeId = changeId;
	}

	public String getCusPhone() {
		return this.cusPhone;
	}

	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}

	public Integer getNewRoomId() {
		return this.newRoomId;
	}

	public void setNewRoomId(Integer newRoomId) {
		this.newRoomId = newRoomId;
	}

	public Float getTotalCost() {
		return this.totalCost;
	}

	public void setTotalCost(Float totalCost) {
		this.totalCost = totalCost;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Integer getIsSettle() {
		return this.isSettle;
	}

	public void setIsSettle(Integer isSettle) {
		this.isSettle = isSettle;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}