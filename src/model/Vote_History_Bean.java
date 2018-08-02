package model;

public class Vote_History_Bean {
	private String con_d;
	private String con_d_id;
	private String con_id;

	public Vote_History_Bean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public Vote_History_Bean(String con_d,String con_d_id,String con_id) {
		this.setCon_d_id(con_d_id);
		this.setCon_d(con_d);
		this.setCon_id(con_id);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public String getCon_d() {
		return con_d;
	}

	public void setCon_d(String con_d) {
		this.con_d = con_d;
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

}
