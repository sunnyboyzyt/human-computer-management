package model;

/**
 * TAnswerKey entity. @author MyEclipse Persistence Tools
 */

public class TAnswerKey implements java.io.Serializable {

	// Fields

	private Integer akeyid;
	private String akey;
	private String akeyname;
	private Integer itemid;

	// Constructors

	/** default constructor */
	public TAnswerKey() {
	}

	/** minimal constructor */
	public TAnswerKey(Integer itemid) {
		this.itemid = itemid;
	}

	/** full constructor */
	public TAnswerKey(String akey, String akeyname, Integer itemid) {
		this.akey = akey;
		this.akeyname = akeyname;
		this.itemid = itemid;
	}

	// Property accessors

	public Integer getAkeyid() {
		return this.akeyid;
	}

	public void setAkeyid(Integer akeyid) {
		this.akeyid = akeyid;
	}

	public String getAkey() {
		return this.akey;
	}

	public void setAkey(String akey) {
		this.akey = akey;
	}

	public String getAkeyname() {
		return this.akeyname;
	}

	public void setAkeyname(String akeyname) {
		this.akeyname = akeyname;
	}

	public Integer getItemid() {
		return this.itemid;
	}

	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}

}