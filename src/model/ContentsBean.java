package model;

import java.util.Date;

public class ContentsBean implements Serializabl{
	private String conId;
	private String userId;
	private String cateId;
	private String conName;
	private Date createDate;
	private Date createEnd;
	private int totalVote;

	public ContentsBean() {
		// TODO ©®¶¬³ê½RXgN^[EX^u
	}

	public String getConId() {
		return conId;
	}

	public void setConId(String conId) {
		this.conId = conId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCateId() {
		return cateId;
	}

	public void setCateId(String cateId) {
		this.cateId = cateId;
	}

	public String getConName() {
		return conName;
	}

	public void setConName(String conName) {
		this.conName = conName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCreateEnd() {
		return createEnd;
	}

	public void setCreateEnd(Date createEnd) {
		this.createEnd = createEnd;
	}

	public int getTotalVote() {
		return totalVote;
	}

	public void setTotalVote(int totalVote) {
		this.totalVote = totalVote;
	}
}
