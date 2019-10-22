package model;


/**
 * TPastSick entity. @author MyEclipse Persistence Tools
 */

public class TPastSick implements java.io.Serializable {

	// Fields

	private Integer pastsickid;
	private String pasthealth;
	private String date;
	private String realization;
	private String medical;
	private String returnsituation;
	private String istrauma;
	private String issurgery;
	private String hospital;
	private Integer patientid;

	// Constructors

	/** default constructor */
	public TPastSick() {
	}

	/** minimal constructor */
	public TPastSick(Integer patientid) {
		this.patientid = patientid;
	}

	/** full constructor */
	public TPastSick(String pasthealth, String date, String realization,
			String medical, String returnsituation, String istrauma,
			String issurgery, String hospital, Integer patientid) {
		this.pasthealth = pasthealth;
		this.date = date;
		this.realization = realization;
		this.medical = medical;
		this.returnsituation = returnsituation;
		this.istrauma = istrauma;
		this.issurgery = issurgery;
		this.hospital = hospital;
		this.patientid = patientid;
	}

	// Property accessors

	public Integer getPastsickid() {
		return this.pastsickid;
	}

	public void setPastsickid(Integer pastsickid) {
		this.pastsickid = pastsickid;
	}

	public String getPasthealth() {
		return this.pasthealth;
	}

	public void setPasthealth(String pasthealth) {
		this.pasthealth = pasthealth;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRealization() {
		return this.realization;
	}

	public void setRealization(String realization) {
		this.realization = realization;
	}

	public String getMedical() {
		return this.medical;
	}

	public void setMedical(String medical) {
		this.medical = medical;
	}

	public String getReturnsituation() {
		return this.returnsituation;
	}

	public void setReturnsituation(String returnsituation) {
		this.returnsituation = returnsituation;
	}

	public String getIstrauma() {
		return this.istrauma;
	}

	public void setIstrauma(String istrauma) {
		this.istrauma = istrauma;
	}

	public String getIssurgery() {
		return this.issurgery;
	}

	public void setIssurgery(String issurgery) {
		this.issurgery = issurgery;
	}

	public String getHospital() {
		return this.hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public Integer getPatientid() {
		return this.patientid;
	}

	public void setPatientid(Integer patientid) {
		this.patientid = patientid;
	}

}