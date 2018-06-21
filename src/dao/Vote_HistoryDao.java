package dao;

public class Vote_HistoryDao extends DaoBase{

	public Vote_HistoryDao() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public void Vote_History_add(String user_id,String con_id,String con_d_id){
			try{
				super.connection();
				String sql = "INSERT INTO `VOTE_HISTROY`(`user_id`,`con_id`,`con_d_id`) VALUES (?,?,?);";
				stmt = con.prepareStatement(sql);
				stmt.setString(1,user_id);
				stmt.setString(2, con_id);
				stmt.setString(3, con_d_id);
				stmt.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					super.DbClose();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
	}

}
