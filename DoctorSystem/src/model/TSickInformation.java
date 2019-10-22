package model;

/**
 * TSickInformation entity. @author MyEclipse Persistence Tools
 */

public class TSickInformation implements java.io.Serializable {

	// Fields

	private Integer informationid;
	private String content1;
	private String content2;

	// Constructors

	/** default constructor */
	public TSickInformation() {
	}

	/** full constructor */
	public TSickInformation(String content1, String content2) {
		this.content1 = content1;
		this.content2 = content2;
	}

	// Property accessors

	public Integer getInformationid() {
		return this.informationid;
	}

	public void setInformationid(Integer informationid) {
		this.informationid = informationid;
	}

	public String getContent1() {
		return this.content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}

	public String getContent2() {
		return this.content2;
	}

	public void setContent2(String content2) {
		this.content2 = content2;
	}

}