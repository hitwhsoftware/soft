package uml.hotel.model;

/**
 * UmlGoods entity. @author MyEclipse Persistence Tools
 */

public class UmlGoods implements java.io.Serializable {

	// Fields

	private Integer gid;
	private Integer goodId;
	private String goodName;
	private Float goodPrice;
	private Integer goodNum;

	// Constructors

	/** default constructor */
	public UmlGoods() {
	}

	/** full constructor */
	public UmlGoods(Integer goodId, String goodName, Float goodPrice,
			Integer goodNum) {
		this.goodId = goodId;
		this.goodName = goodName;
		this.goodPrice = goodPrice;
		this.goodNum = goodNum;
	}

	// Property accessors

	public Integer getGid() {
		return this.gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public Integer getGoodId() {
		return this.goodId;
	}

	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}

	public String getGoodName() {
		return this.goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public Float getGoodPrice() {
		return this.goodPrice;
	}

	public void setGoodPrice(Float goodPrice) {
		this.goodPrice = goodPrice;
	}

	public Integer getGoodNum() {
		return this.goodNum;
	}

	public void setGoodNum(Integer goodNum) {
		this.goodNum = goodNum;
	}

}