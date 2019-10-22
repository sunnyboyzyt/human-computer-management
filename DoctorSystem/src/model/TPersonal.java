package model;

/**
 * TPersonal entity. @author MyEclipse Persistence Tools
 */

public class TPersonal implements java.io.Serializable {

	// Fields

	private Integer personalid;
	private String grow;
	private String menses;
	private String fertility;
	private String family;
	private Integer patientid;

	// Constructors

	/** default constructor */
	public TPersonal() {
	}

	/** minimal constructor */
	public TPersonal(Integer patientid) {
		this.patientid = patientid;
	}

	/** full constructor */
	public TPersonal(String grow, String menses, String fertility,
			String family, Integer patientid) {
		this.grow = grow;
		this.menses = menses;
		this.fertility = fertility;
		this.family = family;
		this.patientid = patientid;
	}

	// Property accessors

	public Integer getPersonalid() {
		return this.personalid;
	}

	public void setPersonalid(Integer personalid) {
		this.personalid = personalid;
	}

	public String getGrow() {
		return this.grow;
	}

	public void setGrow(String grow) {
		this.grow = grow;
	}

	public String getMenses() {
		return this.menses;
	}

	public void setMenses(String menses) {
		this.menses = menses;
	}

	public String getFertility() {
		return this.fertility;
	}

	public void setFertility(String fertility) {
		this.fertility = fertility;
	}

	public String getFamily() {
		return this.family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public Integer getPatientid() {
		return this.patientid;
	}

	public void setPatientid(Integer patientid) {
		this.patientid = patientid;
	}

}