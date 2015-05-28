package proj.dor.model;

/**
 * Checkdormitory entity. @author MyEclipse Persistence Tools
 */

public class Checkdormitory implements java.io.Serializable {

	// Fields

	private Integer cid;
	private String dorId;
	private String isquilt;
	private String isgarbage;
	private String isdesk;
	private String isbalcony;
	private String checkDate;
	private String score;
	private String remark;

	// Constructors

	/** default constructor */
	public Checkdormitory() {
	}

	/** full constructor */
	public Checkdormitory(String dorId, String isquilt, String isgarbage,
			String isdesk, String isbalcony, String checkDate, String score,
			String remark) {
		this.dorId = dorId;
		this.isquilt = isquilt;
		this.isgarbage = isgarbage;
		this.isdesk = isdesk;
		this.isbalcony = isbalcony;
		this.checkDate = checkDate;
		this.score = score;
		this.remark = remark;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getDorId() {
		return this.dorId;
	}

	public void setDorId(String dorId) {
		this.dorId = dorId;
	}

	public String getIsquilt() {
		return this.isquilt;
	}

	public void setIsquilt(String isquilt) {
		this.isquilt = isquilt;
	}

	public String getIsgarbage() {
		return this.isgarbage;
	}

	public void setIsgarbage(String isgarbage) {
		this.isgarbage = isgarbage;
	}

	public String getIsdesk() {
		return this.isdesk;
	}

	public void setIsdesk(String isdesk) {
		this.isdesk = isdesk;
	}

	public String getIsbalcony() {
		return this.isbalcony;
	}

	public void setIsbalcony(String isbalcony) {
		this.isbalcony = isbalcony;
	}

	public String getCheckDate() {
		return this.checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	public String getScore() {
		return this.score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}