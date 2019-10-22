package model;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */

public class TUser implements java.io.Serializable {

	// Fields

	private Integer userid;
	private String name;
	private String gender;
	private String pwd;
	private String phone;
	private Integer classid;
	private Integer roleid;
	private Integer isdelete;
	private String remarks;
	private Integer photoid;

	// Constructors

	/** default constructor */
	public TUser() {
	}

	/** minimal constructor */
	public TUser(Integer userid, Integer classid, Integer roleid,
			Integer isdelete, Integer photoid) {
		this.userid = userid;
		this.classid = classid;
		this.roleid = roleid;
		this.isdelete = isdelete;
		this.photoid = photoid;
	}

	/** full constructor */
	public TUser(Integer userid, String name, String gender, String pwd,
			String phone, Integer classid, Integer roleid, Integer isdelete,
			String remarks, Integer photoid) {
		this.userid = userid;
		this.name = name;
		this.gender = gender;
		this.pwd = pwd;
		this.phone = phone;
		this.classid = classid;
		this.roleid = roleid;
		this.isdelete = isdelete;
		this.remarks = remarks;
		this.photoid = photoid;
	}

	// Property accessors

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getClassid() {
		return this.classid;
	}

	public void setClassid(Integer classid) {
		this.classid = classid;
	}

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public Integer getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getPhotoid() {
		return this.photoid;
	}

	public void setPhotoid(Integer photoid) {
		this.photoid = photoid;
	}

}