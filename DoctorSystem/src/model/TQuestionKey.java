package model;

/**
 * TQuestionKey entity. @author MyEclipse Persistence Tools
 */

public class TQuestionKey implements java.io.Serializable {

	// Fields

	private Integer qkeyid;
	private String qkey;
	private String qkeyname;
	private Integer itemid;

	// Constructors

	/** default constructor */
	public TQuestionKey() {
	}

	/** minimal constructor */
	public TQuestionKey(Integer itemid) {
		this.itemid = itemid;
	}

	/** full constructor */
	public TQuestionKey(String qkey, String qkeyname, Integer itemid) {
		this.qkey = qkey;
		this.qkeyname = qkeyname;
		this.itemid = itemid;
	}

	// Property accessors

	public Integer getQkeyid() {
		return this.qkeyid;
	}

	public void setQkeyid(Integer qkeyid) {
		this.qkeyid = qkeyid;
	}

	public String getQkey() {
		return this.qkey;
	}

	public void setQkey(String qkey) {
		this.qkey = qkey;
	}

	public String getQkeyname() {
		return this.qkeyname;
	}

	public void setQkeyname(String qkeyname) {
		this.qkeyname = qkeyname;
	}

	public Integer getItemid() {
		return this.itemid;
	}

	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}

}