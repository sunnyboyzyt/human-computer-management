package model;

import java.sql.Timestamp;

/**
 * TPatient entity. @author MyEclipse Persistence Tools
 */

public class TPatient implements java.io.Serializable {

	// Fields

	private Integer patientid;
	private String name;
	private String gender;
	private Integer age;
	private String job;
	private String nationality;
	private String birthplace;
	private String marriage;
	private String culture;
	private String faith;
	private String addr;
	private String phone;
	private String joindate;
	private Integer unitid;

	// Constructors

	/** default constructor */
	public TPatient() {
	}

	/** minimal constructor */
	public TPatient(Integer unitid) {
		this.unitid = unitid;
	}

	/** full constructor */
	public TPatient(String name, String gender, Integer age, String job,
			String nationality, String birthplace, String marriage,
			String culture, String faith, String addr, String phone,
			String joindate, Integer unitid) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.job = job;
		this.nationality = nationality;
		this.birthplace = birthplace;
		this.marriage = marriage;
		this.culture = culture;
		this.faith = faith;
		this.addr = addr;
		this.phone = phone;
		this.joindate = joindate;
		this.unitid = unitid;
	}

	// Property accessors

	public Integer getPatientid() {
		return this.patientid;
	}

	public void setPatientid(Integer patientid) {
		this.patientid = patientid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getBirthplace() {
		return this.birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public String getMarriage() {
		return this.marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getCulture() {
		return this.culture;
	}

	public void setCulture(String culture) {
		this.culture = culture;
	}

	public String getFaith() {
		return this.faith;
	}

	public void setFaith(String faith) {
		this.faith = faith;
	}

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getJoindate() {
		return this.joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	public Integer getUnitid() {
		return this.unitid;
	}

	public void setUnitid(Integer unitid) {
		this.unitid = unitid;
	}

}