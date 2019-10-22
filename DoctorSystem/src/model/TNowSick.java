package model;


/**
 * TNowSick entity. @author MyEclipse Persistence Tools
 */

public class TNowSick implements java.io.Serializable {

	// Fields

	private Integer nowsicktid;
	private String sicksituation;
	private String sickdate;
	private String cause;
	private String mainsymptom;
	private String othersymptom;
	private String sickchange;
	private String helpprocess;
	private Integer patientid;

	// Constructors

	/** default constructor */
	public TNowSick() {
	}

	/** minimal constructor */
	public TNowSick(Integer patientid) {
		this.patientid = patientid;
	}

	/** full constructor */
	public TNowSick(String sicksituation, String sickdate, String cause,
			String mainsymptom, String othersymptom, String sickchange,
			String helpprocess, Integer patientid) {
		this.sicksituation = sicksituation;
		this.sickdate = sickdate;
		this.cause = cause;
		this.mainsymptom = mainsymptom;
		this.othersymptom = othersymptom;
		this.sickchange = sickchange;
		this.helpprocess = helpprocess;
		this.patientid = patientid;
	}

	// Property accessors

	public Integer getNowsicktid() {
		return this.nowsicktid;
	}

	public void setNowsicktid(Integer nowsicktid) {
		this.nowsicktid = nowsicktid;
	}

	public String getSicksituation() {
		return this.sicksituation;
	}

	public void setSicksituation(String sicksituation) {
		this.sicksituation = sicksituation;
	}

	public String getSickdate() {
		return this.sickdate;
	}

	public void setSickdate(String sickdate) {
		this.sickdate = sickdate;
	}

	public String getCause() {
		return this.cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public String getMainsymptom() {
		return this.mainsymptom;
	}

	public void setMainsymptom(String mainsymptom) {
		this.mainsymptom = mainsymptom;
	}

	public String getOthersymptom() {
		return this.othersymptom;
	}

	public void setOthersymptom(String othersymptom) {
		this.othersymptom = othersymptom;
	}

	public String getSickchange() {
		return this.sickchange;
	}

	public void setSickchange(String sickchange) {
		this.sickchange = sickchange;
	}

	public String getHelpprocess() {
		return this.helpprocess;
	}

	public void setHelpprocess(String helpprocess) {
		this.helpprocess = helpprocess;
	}

	public Integer getPatientid() {
		return this.patientid;
	}

	public void setPatientid(Integer patientid) {
		this.patientid = patientid;
	}

}