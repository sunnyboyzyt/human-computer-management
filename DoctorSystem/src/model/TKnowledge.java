package model;

/**
 * TKnowledge entity. @author MyEclipse Persistence Tools
 */

public class TKnowledge implements java.io.Serializable {

	// Fields

	private Integer knowledgeid;
	private String knowledgecontent;

	// Constructors

	/** default constructor */
	public TKnowledge() {
	}

	/** full constructor */
	public TKnowledge(String knowledgecontent) {
		this.knowledgecontent = knowledgecontent;
	}

	// Property accessors

	public Integer getKnowledgeid() {
		return this.knowledgeid;
	}

	public void setKnowledgeid(Integer knowledgeid) {
		this.knowledgeid = knowledgeid;
	}

	public String getKnowledgecontent() {
		return this.knowledgecontent;
	}

	public void setKnowledgecontent(String knowledgecontent) {
		this.knowledgecontent = knowledgecontent;
	}

}