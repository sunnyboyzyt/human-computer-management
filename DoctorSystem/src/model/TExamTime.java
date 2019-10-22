package model;


/**
 * TExamTime entity. @author MyEclipse Persistence Tools
 */

public class TExamTime implements java.io.Serializable {

	// Fields

	private Integer examtimeid;
	private String examtimename;
	private String begindate;
	private String enddate;
	private Integer unitid;

	// Constructors

	/** default constructor */
	public TExamTime() {
	}

	/** minimal constructor */
	public TExamTime(Integer unitid) {
		this.unitid = unitid;
	}

	/** full constructor */
	public TExamTime(String examtimename, String begindate,
			String enddate, Integer unitid) {
		this.examtimename = examtimename;
		this.begindate = begindate;
		this.enddate = enddate;
		this.unitid = unitid;
	}

	// Property accessors

	public Integer getExamtimeid() {
		return this.examtimeid;
	}

	public void setExamtimeid(Integer examtimeid) {
		this.examtimeid = examtimeid;
	}

	public String getExamtimename() {
		return this.examtimename;
	}

	public void setExamtimename(String examtimename) {
		this.examtimename = examtimename;
	}

	public String getBegindate() {
		return this.begindate;
	}

	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}

	public String getEnddate() {
		return this.enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public Integer getUnitid() {
		return this.unitid;
	}

	public void setUnitid(Integer unitid) {
		this.unitid = unitid;
	}

}