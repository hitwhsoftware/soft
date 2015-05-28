package proj.dor.model;

/**
 * Dormitory entity. @author MyEclipse Persistence Tools
 */

public class Dormitory implements java.io.Serializable {

	// Fields

	private Integer did;
	private String dorId;
	private String gread;

	// Constructors

	/** default constructor */
	public Dormitory() {
	}

	/** minimal constructor */
	public Dormitory(Integer did) {
		this.did = did;
	}

	/** full constructor */
	public Dormitory(Integer did, String dorId, String gread) {
		this.did = did;
		this.dorId = dorId;
		this.gread = gread;
	}

	// Property accessors

	public Integer getDid() {
		return this.did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getDorId() {
		return this.dorId;
	}

	public void setDorId(String dorId) {
		this.dorId = dorId;
	}

	public String getGread() {
		return this.gread;
	}

	public void setGread(String gread) {
		this.gread = gread;
	}

}