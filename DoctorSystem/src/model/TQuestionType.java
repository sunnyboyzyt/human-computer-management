package model;

/**
 * TQuestionType entity. @author MyEclipse Persistence Tools
 */

public class TQuestionType implements java.io.Serializable {

	// Fields

	private Integer itemid;
	private String itemname;

	// Constructors

	/** default constructor */
	public TQuestionType() {
	}

	/** full constructor */
	public TQuestionType(String itemname) {
		this.itemname = itemname;
	}

	// Property accessors

	public Integer getItemid() {
		return this.itemid;
	}

	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}

	public String getItemname() {
		return this.itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

}