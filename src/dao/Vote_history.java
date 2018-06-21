package dao;

public class Vote_history extends DaoBase{

	public Vote_history() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public void addhistory(String user_id,String con_id,String con_d_id){
		try {
			super.connection();
			String sql = "insert into vote_history(user_id,con_id,con_d_id) values(?,?,?)";

			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, user_id);
			stmt.setString(2, con_id);
			stmt.setString(3,con_d_id);
	
			stmt.executeUpdate();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	
}
