package model;

/**
 * TPhoto entity. @author MyEclipse Persistence Tools
 */

public class TPhoto implements java.io.Serializable {

	// Fields

	private Integer photoid;
	private String photopath;
	private Integer status;

	// Constructors

	/** default constructor */
	public TPhoto() {
	}

	/** minimal constructor */
	public TPhoto(Integer status) {
		this.status = status;
	}

	/** full constructor */
	public TPhoto(String photopath, Integer status) {
		this.photopath = photopath;
		this.status = status;
	}

	// Property accessors

	public Integer getPhotoid() {
		return this.photoid;
	}

	public void setPhotoid(Integer photoid) {
		this.photoid = photoid;
	}

	public String getPhotopath() {
		return this.photopath;
	}

	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}