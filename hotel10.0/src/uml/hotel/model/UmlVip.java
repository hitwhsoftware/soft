package uml.hotel.model;

/**
 * UmlVip entity. @author MyEclipse Persistence Tools
 */

public class UmlVip implements java.io.Serializable {

	// Fields

	private Integer vid;
	private Integer vipId;
	private String vipName;
	private Float discount;

	// Constructors

	/** default constructor */
	public UmlVip() {
	}

	/** full constructor */
	public UmlVip(Integer vipId, String vipName, Float discount) {
		this.vipId = vipId;
		this.vipName = vipName;
		this.discount = discount;
	}

	// Property accessors

	public Integer getVid() {
		return this.vid;
	}

	public void setVid(Integer vid) {
		this.vid = vid;
	}

	public Integer getVipId() {
		return this.vipId;
	}

	public void setVipId(Integer vipId) {
		this.vipId = vipId;
	}

	public String getVipName() {
		return this.vipName;
	}

	public void setVipName(String vipName) {
		this.vipName = vipName;
	}

	public Float getDiscount() {
		return this.discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

}