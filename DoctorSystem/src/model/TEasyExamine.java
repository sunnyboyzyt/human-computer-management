package model;

/**
 * TEasyExamine entity. @author MyEclipse Persistence Tools
 */

public class TEasyExamine implements java.io.Serializable {

	// Fields

	private Integer easyexamineid;
	private String easyexamineitem;
	private String easyexamineparam;
	private Integer patientid;

	// Constructors

	/** default constructor */
	public TEasyExamine() {
	}

	/** minimal constructor */
	public TEasyExamine(Integer patientid) {
		this.patientid = patientid;
	}

	/** full constructor */
	public TEasyExamine(String easyexamineitem, String easyexamineparam,
			Integer patientid) {
		this.easyexamineitem = easyexamineitem;
		this.easyexamineparam = easyexamineparam;
		this.patientid = patientid;
	}

	// Property accessors

	public Integer getEasyexamineid() {
		return this.easyexamineid;
	}

	public void setEasyexamineid(Integer easyexamineid) {
		this.easyexamineid = easyexamineid;
	}

	public String getEasyexamineitem() {
		return this.easyexamineitem;
	}

	public void setEasyexamineitem(String easyexamineitem) {
		this.easyexamineitem = easyexamineitem;
	}

	public String getEasyexamineparam() {
		return this.easyexamineparam;
	}

	public void setEasyexamineparam(String easyexamineparam) {
		this.easyexamineparam = easyexamineparam;
	}

	public Integer getPatientid() {
		return this.patientid;
	}

	public void setPatientid(Integer patientid) {
		this.patientid = patientid;
	}

}