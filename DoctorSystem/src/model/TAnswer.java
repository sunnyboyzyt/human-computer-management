package model;

/**
 * TAnswer entity. @author MyEclipse Persistence Tools
 */

public class TAnswer implements java.io.Serializable {

	// Fields

	private Integer answerid;
	private String answer;
	private Integer answeritemid;
	private Integer userid;
	private Integer examinationid;
	private Integer patientid;

	// Constructors

	/** default constructor */
	public TAnswer() {
	}

	/** minimal constructor */
	public TAnswer(Integer patientid) {
		this.patientid = patientid;
	}

	/** full constructor */
	public TAnswer(String answer, Integer answeritemid, Integer userid,
			Integer examinationid, Integer patientid) {
		this.answer = answer;
		this.answeritemid = answeritemid;
		this.userid = userid;
		this.examinationid = examinationid;
		this.patientid = patientid;
	}

	// Property accessors

	public Integer getAnswerid() {
		return this.answerid;
	}

	public void setAnswerid(Integer answerid) {
		this.answerid = answerid;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Integer getAnsweritemid() {
		return this.answeritemid;
	}

	public void setAnsweritemid(Integer answeritemid) {
		this.answeritemid = answeritemid;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getExaminationid() {
		return this.examinationid;
	}

	public void setExaminationid(Integer examinationid) {
		this.examinationid = examinationid;
	}

	public Integer getPatientid() {
		return this.patientid;
	}

	public void setPatientid(Integer patientid) {
		this.patientid = patientid;
	}

}