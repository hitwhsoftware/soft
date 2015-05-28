package uml.hotel.model;

/**
 * UmlCustomer entity. @author MyEclipse Persistence Tools
 */

public class UmlCustomer implements java.io.Serializable {

	// Fields

	private Integer cid;
	private String cusName;
	private String cusPhone;
	private String cusId;
	private String sex;
	private String cusPwd;
	private Integer statusId;
	private Integer vipId;

	// Constructors

	/** default constructor */
	public UmlCustomer() {
	}

	/** full constructor */
	public UmlCustomer(String cusName, String cusPhone, String cusId,
			String sex, String cusPwd, Integer statusId, Integer vipId) {
		this.cusName = cusName;
		this.cusPhone = cusPhone;
		this.cusId = cusId;
		this.sex = sex;
		this.cusPwd = cusPwd;
		this.statusId = statusId;
		this.vipId = vipId;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCusName() {
		return this.cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusPhone() {
		return this.cusPhone;
	}

	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}

	public String getCusId() {
		return this.cusId;
	}

	public void setCusId(String cusId) {
		this.cusId = cusId;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCusPwd() {
		return this.cusPwd;
	}

	public void setCusPwd(String cusPwd) {
		this.cusPwd = cusPwd;
	}

	public Integer getStatusId() {
		return this.statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public Integer getVipId() {
		return this.vipId;
	}

	public void setVipId(Integer vipId) {
		this.vipId = vipId;
	}

}