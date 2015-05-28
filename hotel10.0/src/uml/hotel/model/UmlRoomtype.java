package uml.hotel.model;

/**
 * UmlRoomtype entity. @author MyEclipse Persistence Tools
 */

public class UmlRoomtype implements java.io.Serializable {

	// Fields

	private Integer tid;
	private Integer typeId;
	private String roomType;
	private Float roomPrice;

	// Constructors

	/** default constructor */
	public UmlRoomtype() {
	}

	/** full constructor */
	public UmlRoomtype(Integer typeId, String roomType, Float roomPrice) {
		this.typeId = typeId;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
	}

	// Property accessors

	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getRoomType() {
		return this.roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Float getRoomPrice() {
		return this.roomPrice;
	}

	public void setRoomPrice(Float roomPrice) {
		this.roomPrice = roomPrice;
	}

}