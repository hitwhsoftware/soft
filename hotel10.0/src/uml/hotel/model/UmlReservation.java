package uml.hotel.model;

import java.sql.Timestamp;

/**
 * UmlReservation entity. @author MyEclipse Persistence Tools
 */

public class UmlReservation implements java.io.Serializable {

	// Fields

	private Integer reId;
	private Integer reserId;
	private Integer roomId;
	private String cusPhone;
	private Timestamp rstartTime;
	private Timestamp rendTime;
	private Timestamp reserTime;
	private Integer isSettle;
	private String remark;

	// Constructors

	/** default constructor */
	public UmlReservation() {
	}

	/** full constructor */
	public UmlReservation(Integer reserId, Integer roomId, String cusPhone,
			Timestamp rstartTime, Timestamp rendTime, Timestamp reserTime,
			Integer isSettle, String remark) {
		this.reserId = reserId;
		this.roomId = roomId;
		this.cusPhone = cusPhone;
		this.rstartTime = rstartTime;
		this.rendTime = rendTime;
		this.reserTime = reserTime;
		this.isSettle = isSettle;
		this.remark = remark;
	}

	// Property accessors

	public Integer getReId() {
		return this.reId;
	}

	public void setReId(Integer reId) {
		this.reId = reId;
	}

	public Integer getReserId() {
		return this.reserId;
	}

	public void setReserId(Integer reserId) {
		this.reserId = reserId;
	}

	public Integer getRoomId() {
		return this.roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getCusPhone() {
		return this.cusPhone;
	}

	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}

	public Timestamp getRstartTime() {
		return this.rstartTime;
	}

	public void setRstartTime(Timestamp rstartTime) {
		this.rstartTime = rstartTime;
	}

	public Timestamp getRendTime() {
		return this.rendTime;
	}

	public void setRendTime(Timestamp rendTime) {
		this.rendTime = rendTime;
	}

	public Timestamp getReserTime() {
		return this.reserTime;
	}

	public void setReserTime(Timestamp reserTime) {
		this.reserTime = reserTime;
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