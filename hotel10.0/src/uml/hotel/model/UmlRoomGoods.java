package uml.hotel.model;

/**
 * UmlRoomGoods entity. @author MyEclipse Persistence Tools
 */

public class UmlRoomGoods implements java.io.Serializable {

	// Fields

	private Integer ctId;
	private Integer costId;
	private Integer roomId;
	private Integer goodId;
	private Integer goodNum;
	private Integer isSettle;
	private String remark;

	// Constructors

	/** default constructor */
	public UmlRoomGoods() {
	}

	/** full constructor */
	public UmlRoomGoods(Integer costId, Integer roomId, Integer goodId,
			Integer goodNum, Integer isSettle, String remark) {
		this.costId = costId;
		this.roomId = roomId;
		this.goodId = goodId;
		this.goodNum = goodNum;
		this.isSettle = isSettle;
		this.remark = remark;
	}

	// Property accessors

	public Integer getCtId() {
		return this.ctId;
	}

	public void setCtId(Integer ctId) {
		this.ctId = ctId;
	}

	public Integer getCostId() {
		return this.costId;
	}

	public void setCostId(Integer costId) {
		this.costId = costId;
	}

	public Integer getRoomId() {
		return this.roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Integer getGoodId() {
		return this.goodId;
	}

	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}

	public Integer getGoodNum() {
		return this.goodNum;
	}

	public void setGoodNum(Integer goodNum) {
		this.goodNum = goodNum;
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