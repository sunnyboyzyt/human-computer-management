package model;

/**
 * TChart entity. @author MyEclipse Persistence Tools
 */

public class TChart implements java.io.Serializable {

	// Fields

	private Integer chartid;
	private String chartname;
	private Integer photoid;
	private String description;

	// Constructors

	/** default constructor */
	public TChart() {
	}

	/** full constructor */
	public TChart(String chartname, Integer photoid, String description) {
		this.chartname = chartname;
		this.photoid = photoid;
		this.description = description;
	}

	// Property accessors

	public Integer getChartid() {
		return this.chartid;
	}

	public void setChartid(Integer chartid) {
		this.chartid = chartid;
	}

	public String getChartname() {
		return this.chartname;
	}

	public void setChartname(String chartname) {
		this.chartname = chartname;
	}

	public Integer getPhotoid() {
		return this.photoid;
	}

	public void setPhotoid(Integer photoid) {
		this.photoid = photoid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}