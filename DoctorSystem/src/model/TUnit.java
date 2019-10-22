package model;

/**
 * TUnit entity. @author MyEclipse Persistence Tools
 */

public class TUnit implements java.io.Serializable {

	// Fields

	private Integer unitid;
	private String unitcode;
	private String unitname;

	// Constructors

	/** default constructor */
	public TUnit() {
	}

	/** full constructor */
	public TUnit(String unitcode, String unitname) {
		this.unitcode = unitcode;
		this.unitname = unitname;
	}

	// Property accessors

	public Integer getUnitid() {
		return this.unitid;
	}

	public void setUnitid(Integer unitid) {
		this.unitid = unitid;
	}

	public String getUnitcode() {
		return this.unitcode;
	}

	public void setUnitcode(String unitcode) {
		this.unitcode = unitcode;
	}

	public String getUnitname() {
		return this.unitname;
	}

	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}

}