package uml.hotel.model;

/**
 * UmlAdmin entity. @author MyEclipse Persistence Tools
 */

public class UmlAdmin implements java.io.Serializable {

	// Fields

	private Integer adminId;
	private String adminName;
	private String adminPwd;
	private Integer authId;

	// Constructors

	/** default constructor */
	public UmlAdmin() {
	}

	/** full constructor */
	public UmlAdmin(String adminName, String adminPwd, Integer authId) {
		this.adminName = adminName;
		this.adminPwd = adminPwd;
		this.authId = authId;
	}

	// Property accessors

	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPwd() {
		return this.adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	public Integer getAuthId() {
		return this.authId;
	}

	public void setAuthId(Integer authId) {
		this.authId = authId;
	}

}