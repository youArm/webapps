package dao;

public class VOTE_MANAGEMENT_Dao extends DaoBase{

	public VOTE_MANAGEMENT_Dao() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public boolean votecheck(String userid,String Con_d) {

		boolean flg = false;

		try {
			// connection確立
			super.connection();

			String selectSQL = "select count(*) from vote_management where user_id = ? && con_id= ?";

			stmt = con.prepareStatement(selectSQL);
			// SQLの？に値のセット
			stmt.setString(1, userid);
			stmt.setString(2,Con_d);
			rs = stmt.executeQuery();

			rs.next();

			if (rs.getInt(1) > 0) {
				flg = false;
			} else {
				flg = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// エラー時はclose処理
				super.DbClose();
			} catch (Exception e) {
				System.out.println("error");
			}
		}
		return flg;
	}
	public void vortcheck(String user_id ,String con_id){
		try{
			super.connection();
			String sql = "INSERT INTO `vote_management`(`user_id`,`con_id`) VALUES (?,?);";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, user_id);
			stmt.setString(2, con_id);
			int num = stmt.executeUpdate();
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
