package model;

/**
 * TChiefComplaint entity. @author MyEclipse Persistence Tools
 */

public class TChiefComplaint implements java.io.Serializable {

	// Fields

	private Integer chiefComplaintid;
	private String symptom;
	private String nature;
	private String degree;
	private String continueddate;
	private Integer patientid;

	// Constructors

	/** default constructor */
	public TChiefComplaint() {
	}

	/** minimal constructor */
	public TChiefComplaint(Integer patientid) {
		this.patientid = patientid;
	}

	/** full constructor */
	public TChiefComplaint(String symptom, String nature, String degree,
			String continueddate, Integer patientid) {
		this.symptom = symptom;
		this.nature = nature;
		this.degree = degree;
		this.continueddate = continueddate;
		this.patientid = patientid;
	}

	// Property accessors

	public Integer getChiefComplaintid() {
		return this.chiefComplaintid;
	}

	public void setChiefComplaintid(Integer chiefComplaintid) {
		this.chiefComplaintid = chiefComplaintid;
	}

	public String getSymptom() {
		return this.symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public String getNature() {
		return this.nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getContinueddate() {
		return this.continueddate;
	}

	public void setContinueddate(String continueddate) {
		this.continueddate = continueddate;
	}

	public Integer getPatientid() {
		return this.patientid;
	}

	public void setPatientid(Integer patientid) {
		this.patientid = patientid;
	}

}