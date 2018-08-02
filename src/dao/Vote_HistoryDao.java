package dao;

import java.sql.ResultSet;

import model.Vote_History_Bean;
import model.Vote_Info_Bean;

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
	    String con_d_id_name;
	    String con_d_name;
	    ResultSet rs1=null;	
	    ResultSet rs2=null;	
		
		try{
			super.connection();
			String sql = "SELECT * from `vote_history` where user_id=?;";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, user_id);
	        rs = stmt.executeQuery();
	        while(rs.next()){
	        	con_d=rs.getString(2);
	        	con_d_id=rs.getString(3);
	        	sql = "SELECT * from `contents_details` where con_id=? and con_d_id=?;";
	        	stmt = con.prepareStatement(sql);
				stmt.setString(1, con_d);
				stmt.setString(2, con_d_id);
		        rs1 = stmt.executeQuery();
		        
		        rs1.next();
		        
	        	con_d_id_name=rs1.getString(3);
	        	
		        sql = "SELECT * from `contents` where con_id=?;";
	        	stmt = con.prepareStatement(sql);
				stmt.setString(1, con_d);
		        rs2 = stmt.executeQuery();
		        
		        rs2.next();
		        
		        con_d_name=rs2.getString(4);
		        
	        	list.addList(new Vote_History_Bean(con_d_name,con_d_id_name,con_d));
	        }
		}catch(Exception e){
			System.out.println(e);
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
