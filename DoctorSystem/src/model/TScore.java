package model;

/**
 * TScore entity. @author MyEclipse Persistence Tools
 */

public class TScore implements java.io.Serializable {

	// Fields

	private Integer scoreid;
	private Integer examid;
	private Integer userid;
	private Double score1;
	private Double score2;
	private Double score3;
	private Double score4;
	private Double allscore;

	// Constructors

	/** default constructor */
	public TScore() {
	}

	/** minimal constructor */
	public TScore(Integer examid, Integer userid, Double score1, Double score2,
			Double score3, Double score4) {
		this.examid = examid;
		this.userid = userid;
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
		this.score4 = score4;
	}

	/** full constructor */
	public TScore(Integer examid, Integer userid, Double score1, Double score2,
			Double score3, Double score4, Double allscore) {
		this.examid = examid;
		this.userid = userid;
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
		this.score4 = score4;
		this.allscore = allscore;
	}

	// Property accessors

	public Integer getScoreid() {
		return this.scoreid;
	}

	public void setScoreid(Integer scoreid) {
		this.scoreid = scoreid;
	}

	public Integer getExamid() {
		return this.examid;
	}

	public void setExamid(Integer examid) {
		this.examid = examid;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Double getScore1() {
		return this.score1;
	}

	public void setScore1(Double score1) {
		this.score1 = score1;
	}

	public Double getScore2() {
		return this.score2;
	}

	public void setScore2(Double score2) {
		this.score2 = score2;
	}

	public Double getScore3() {
		return this.score3;
	}

	public void setScore3(Double score3) {
		this.score3 = score3;
	}

	public Double getScore4() {
		return this.score4;
	}

	public void setScore4(Double score4) {
		this.score4 = score4;
	}

	public Double getAllscore() {
		return this.allscore;
	}

	public void setAllscore(Double allscore) {
		this.allscore = allscore;
	}

}