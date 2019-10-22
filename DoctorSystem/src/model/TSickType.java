package model;

/**
 * TSickType entity. @author MyEclipse Persistence Tools
 */

public class TSickType implements java.io.Serializable {

	// Fields

	private Integer sicktypeid;
	private String sicktypename;

	// Constructors

	/** default constructor */
	public TSickType() {
	}

	/** full constructor */
	public TSickType(String sicktypename) {
		this.sicktypename = sicktypename;
	}

	// Property accessors

	public Integer getSicktypeid() {
		return this.sicktypeid;
	}

	public void setSicktypeid(Integer sicktypeid) {
		this.sicktypeid = sicktypeid;
	}

	public String getSicktypename() {
		return this.sicktypename;
	}

	public void setSicktypename(String sicktypename) {
		this.sicktypename = sicktypename;
	}

}