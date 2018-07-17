package model;

public class Vote_result_bean {
	private String con_d_id;
	private String con_id;
	private String con_d_name;
	private String description;
	private String image;
	private int votes;

	public Vote_result_bean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public Vote_result_bean(String con_d_id,String con_d_name,String description,String image,int votes){
		this.setCon_d_id(con_d_id);
		this.setCon_d_name(con_d_name);
		this.setDescription(description);
		this.setImage(image);
		this.setVotes(votes);
	}
	public String getCon_d_id() {
		return con_d_id;
	}
	public void setCon_d_id(String con_d_id) {
		this.con_d_id = con_d_id;
	}
	public String getCon_id() {
		return con_id;
	}
	public void setCon_id(String con_id) {
		this.con_id = con_id;
	}
	public String getCon_d_name() {
		return con_d_name;
	}
	public void setCon_d_name(String con_d_name) {
		this.con_d_name = con_d_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}

}
