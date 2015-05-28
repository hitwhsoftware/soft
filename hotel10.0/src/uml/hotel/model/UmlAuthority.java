package uml.hotel.model;

/**
 * UmlAuthority entity. @author MyEclipse Persistence Tools
 */

public class UmlAuthority implements java.io.Serializable {

	// Fields

	private Integer aid;
	private Integer authId;
	private String authClass;

	// Constructors

	/** default constructor */
	public UmlAuthority() {
	}

	/** full constructor */
	public UmlAuthority(Integer authId, String authClass) {
		this.authId = authId;
		this.authClass = authClass;
	}

	// Property accessors

	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public Integer getAuthId() {
		return this.authId;
	}

	public void setAuthId(Integer authId) {
		this.authId = authId;
	}

	public String getAuthClass() {
		return this.authClass;
	}

	public void setAuthClass(String authClass) {
		this.authClass = authClass;
	}

}