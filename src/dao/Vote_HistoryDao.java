package dao;

import model.Vote_History_Bean;
import model.Vote_Info_Bean;
import model.Vote_result_Info_Bean;
import model.Vote_result_bean;

public class Vote_HistoryDao extends DaoBase{

	public Vote_HistoryDao() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public void Vote_History_add(String user_id,String con_id,String con_d_id){
			try{
				super.connection();
				String sql = "INSERT INTO `vote_history`(`user_id`,`con_id`,`con_d_id`) VALUES (?,?,?);";
				stmt = con.prepareStatement(sql);
				stmt.setString(1,user_id);
				stmt.setString(2,con_id);
				stmt.setString(3,con_d_id);
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
	public Vote_Info_Bean History(String user_id){
		Vote_Info_Bean list=new Vote_Info_Bean();
		String con_d;
	    String con_d_id;
		
		try{
			super.connection();
			String sql = "SELECT * from `vote_history` where user_id=?;";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, user_id);
	        rs = stmt.executeQuery();
	        while(rs.next()){
	        	con_d=rs.getString(2);
	        	con_d_id=rs.getString(3);
	        	list.addList(new Vote_History_Bean(con_d,con_d_id));
	        }
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				super.DbClose();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return list;
		
		
	}

}
