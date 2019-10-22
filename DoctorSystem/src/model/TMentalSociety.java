package model;

/**
 * TMentalSociety entity. @author MyEclipse Persistence Tools
 */

public class TMentalSociety implements java.io.Serializable {

	// Fields

	private Integer mentalsocietyid;
	private String self;
	private String knowability;
	private String mood;
	private String sickknow;
	private String stress;
	private String belief;
	private String career;
	private String environment;
	private String familyrelationship;
	private Integer patientid;

	// Constructors

	/** default constructor */
	public TMentalSociety() {
	}

	/** minimal constructor */
	public TMentalSociety(Integer patientid) {
		this.patientid = patientid;
	}

	/** full constructor */
	public TMentalSociety(String self, String knowability, String mood,
			String sickknow, String stress, String belief, String career,
			String environment, String familyrelationship, Integer patientid) {
		this.self = self;
		this.knowability = knowability;
		this.mood = mood;
		this.sickknow = sickknow;
		this.stress = stress;
		this.belief = belief;
		this.career = career;
		this.environment = environment;
		this.familyrelationship = familyrelationship;
		this.patientid = patientid;
	}

	// Property accessors

	public Integer getMentalsocietyid() {
		return this.mentalsocietyid;
	}

	public void setMentalsocietyid(Integer mentalsocietyid) {
		this.mentalsocietyid = mentalsocietyid;
	}

	public String getSelf() {
		return this.self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public String getKnowability() {
		return this.knowability;
	}

	public void setKnowability(String knowability) {
		this.knowability = knowability;
	}

	public String getMood() {
		return this.mood;
	}

	public void setMood(String mood) {
		this.mood = mood;
	}

	public String getSickknow() {
		return this.sickknow;
	}

	public void setSickknow(String sickknow) {
		this.sickknow = sickknow;
	}

	public String getStress() {
		return this.stress;
	}

	public void setStress(String stress) {
		this.stress = stress;
	}

	public String getBelief() {
		return this.belief;
	}

	public void setBelief(String belief) {
		this.belief = belief;
	}

	public String getCareer() {
		return this.career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getEnvironment() {
		return this.environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getFamilyrelationship() {
		return this.familyrelationship;
	}

	public void setFamilyrelationship(String familyrelationship) {
		this.familyrelationship = familyrelationship;
	}

	public Integer getPatientid() {
		return this.patientid;
	}

	public void setPatientid(Integer patientid) {
		this.patientid = patientid;
	}

}