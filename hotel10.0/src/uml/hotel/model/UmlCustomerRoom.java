package uml.hotel.model;

import java.sql.Timestamp;

/**
 * UmlCustomerRoom entity. @author MyEclipse Persistence Tools
 */

public class UmlCustomerRoom implements java.io.Serializable {

	// Fields

	private Integer bid;
	private Integer bookId;
	private Integer roomId;
	private String cusPhone;
	private Timestamp startTime;
	private Timestamp endTime;
	private Integer isSettle;
	private String remark;

	// Constructors

	/** default constructor */
	public UmlCustomerRoom() {
	}

	/** full constructor */
	public UmlCustomerRoom(Integer bookId, Integer roomId, String cusPhone,
			Timestamp startTime, Timestamp endTime, Integer isSettle,
			String remark) {
		this.bookId = bookId;
		this.roomId = roomId;
		this.cusPhone = cusPhone;
		this.startTime = startTime;
		this.endTime = endTime;
		this.isSettle = isSettle;
		this.remark = remark;
	}

	// Property accessors

	public Integer getBid() {
		return this.bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
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