package uml.hotel.model;

/**
 * UmlRoom entity. @author MyEclipse Persistence Tools
 */

public class UmlRoom implements java.io.Serializable {

	// Fields

	private Integer rid;
	private Integer roomId;
	private Integer typeId;
	private Integer isLodge;

	// Constructors

	/** default constructor */
	public UmlRoom() {
	}

	/** full constructor */
	public UmlRoom(Integer roomId, Integer typeId, Integer isLodge) {
		this.roomId = roomId;
		this.typeId = typeId;
		this.isLodge = isLodge;
	}

	// Property accessors

	public Integer getRid() {
		return this.rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Integer getRoomId() {
		return this.roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getIsLodge() {
		return this.isLodge;
	}

	public void setIsLodge(Integer isLodge) {
		this.isLodge = isLodge;
	}

}