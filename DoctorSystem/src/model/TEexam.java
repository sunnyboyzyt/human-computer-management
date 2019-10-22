package model;

/**
 * TEexam entity. @author MyEclipse Persistence Tools
 */

public class TEexam implements java.io.Serializable {

	// Fields

	private Integer examid;
	private Integer userid;
	private Integer examtimeid;
	private Integer patientid;

	// Constructors

	/** default constructor */
	public TEexam() {
	}

	/** full constructor */
	public TEexam(Integer userid, Integer examtimeid, Integer patientid) {
		this.userid = userid;
		this.examtimeid = examtimeid;
		this.patientid = patientid;
	}

	// Property accessors

	public Integer getExamid() {
		return this.examid;
	}

	public void setExamid(Integer examid) {
		this.examid = examid;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getExamtimeid() {
		return this.examtimeid;
	}

	public void setExamtimeid(Integer examtimeid) {
		this.examtimeid = examtimeid;
	}

	public Integer getPatientid() {
		return this.patientid;
	}

	public void setPatientid(Integer patientid) {
		this.patientid = patientid;
	}

}