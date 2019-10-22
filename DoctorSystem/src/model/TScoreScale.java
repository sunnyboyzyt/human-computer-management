package model;

/**
 * TScoreScale entity. @author MyEclipse Persistence Tools
 */

public class TScoreScale implements java.io.Serializable {

	// Fields

	private Integer scorescaleid;
	private String scorescalename;
	private Double scorescale;

	// Constructors

	/** default constructor */
	public TScoreScale() {
	}

	/** minimal constructor */
	public TScoreScale(Double scorescale) {
		this.scorescale = scorescale;
	}

	/** full constructor */
	public TScoreScale(String scorescalename, Double scorescale) {
		this.scorescalename = scorescalename;
		this.scorescale = scorescale;
	}

	// Property accessors

	public Integer getScorescaleid() {
		return this.scorescaleid;
	}

	public void setScorescaleid(Integer scorescaleid) {
		this.scorescaleid = scorescaleid;
	}

	public String getScorescalename() {
		return this.scorescalename;
	}

	public void setScorescalename(String scorescalename) {
		this.scorescalename = scorescalename;
	}

	public Double getScorescale() {
		return this.scorescale;
	}

	public void setScorescale(Double scorescale) {
		this.scorescale = scorescale;
	}

}