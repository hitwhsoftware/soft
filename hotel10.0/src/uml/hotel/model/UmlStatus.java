package uml.hotel.model;

/**
 * UmlStatus entity. @author MyEclipse Persistence Tools
 */

public class UmlStatus implements java.io.Serializable {

	// Fields

	private Integer sid;
	private Integer statusId;
	private String statusName;

	// Constructors

	/** default constructor */
	public UmlStatus() {
	}

	/** full constructor */
	public UmlStatus(Integer statusId, String statusName) {
		this.statusId = statusId;
		this.statusName = statusName;
	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getStatusId() {
		return this.statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return this.statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

}