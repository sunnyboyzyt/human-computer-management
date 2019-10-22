package model;

/**
 * TOtherExamine entity. @author MyEclipse Persistence Tools
 */

public class TOtherExamine implements java.io.Serializable {

	// Fields

	private Integer otherexamineid;
	private String otherexamineitem;
	private String otherexamineparam;
	private Integer patientid;

	// Constructors

	/** default constructor */
	public TOtherExamine() {
	}

	/** minimal constructor */
	public TOtherExamine(Integer patientid) {
		this.patientid = patientid;
	}

	/** full constructor */
	public TOtherExamine(String otherexamineitem, String otherexamineparam,
			Integer patientid) {
		this.otherexamineitem = otherexamineitem;
		this.otherexamineparam = otherexamineparam;
		this.patientid = patientid;
	}

	// Property accessors

	public Integer getOtherexamineid() {
		return this.otherexamineid;
	}

	public void setOtherexamineid(Integer otherexamineid) {
		this.otherexamineid = otherexamineid;
	}

	public String getOtherexamineitem() {
		return this.otherexamineitem;
	}

	public void setOtherexamineitem(String otherexamineitem) {
		this.otherexamineitem = otherexamineitem;
	}

	public String getOtherexamineparam() {
		return this.otherexamineparam;
	}

	public void setOtherexamineparam(String otherexamineparam) {
		this.otherexamineparam = otherexamineparam;
	}

	public Integer getPatientid() {
		return this.patientid;
	}

	public void setPatientid(Integer patientid) {
		this.patientid = patientid;
	}

}