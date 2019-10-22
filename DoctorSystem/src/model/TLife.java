package model;

/**
 * TLife entity. @author MyEclipse Persistence Tools
 */

public class TLife implements java.io.Serializable {

	// Fields

	private Integer lifeid;
	private String diet;
	private String excretion;
	private String sleep;
	private String activity;
	private String useself;
	private String hobby;
	private Integer patientid;

	// Constructors

	/** default constructor */
	public TLife() {
	}

	/** minimal constructor */
	public TLife(Integer patientid) {
		this.patientid = patientid;
	}

	/** full constructor */
	public TLife(String diet, String excretion, String sleep, String activity,
			String useself, String hobby, Integer patientid) {
		this.diet = diet;
		this.excretion = excretion;
		this.sleep = sleep;
		this.activity = activity;
		this.useself = useself;
		this.hobby = hobby;
		this.patientid = patientid;
	}

	// Property accessors

	public Integer getLifeid() {
		return this.lifeid;
	}

	public void setLifeid(Integer lifeid) {
		this.lifeid = lifeid;
	}

	public String getDiet() {
		return this.diet;
	}

	public void setDiet(String diet) {
		this.diet = diet;
	}

	public String getExcretion() {
		return this.excretion;
	}

	public void setExcretion(String excretion) {
		this.excretion = excretion;
	}

	public String getSleep() {
		return this.sleep;
	}

	public void setSleep(String sleep) {
		this.sleep = sleep;
	}

	public String getActivity() {
		return this.activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getUseself() {
		return this.useself;
	}

	public void setUseself(String useself) {
		this.useself = useself;
	}

	public String getHobby() {
		return this.hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Integer getPatientid() {
		return this.patientid;
	}

	public void setPatientid(Integer patientid) {
		this.patientid = patientid;
	}

}