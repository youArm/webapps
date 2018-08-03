package dao;

import java.util.ArrayList;

import model.Vote_result_Info_Bean;
import model.Vote_result_bean;

public class VoteDao extends DaoBase{
	
	public VoteDao(){
		
	};
	
	public void VoteAdd(String con_id,String con_d_id){
		try{
			super.connection();
			String sql = "UPDATE `CONTENTS_DETAILS` SET `votes`=`votes`+1 where con_d_id=? and con_id=?;";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, con_d_id);
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
	
	//総投票数の増加
	public void totalVoteadd(String con_id){
		try{
			super.connection();
			String sql = "UPDATE `CONTENTS` SET `total_vote`=total_vote + 1 where con_id=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, con_id);
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
	
	public  ArrayList<Vote_result_bean> result(String con_id){
		ArrayList<Vote_result_bean> list=new ArrayList<Vote_result_bean>();
	    String con_d_id;
		String con_d_name;
		String description;
		String image;
		int votes;
		
		try{
			super.connection();
			String sql = "SELECT `*` from `CONTENTS_DETAILS` where con_id=?;";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, con_id);
	        rs = stmt.executeQuery();
	        while(rs.next()){
	        	con_d_id=rs.getString(1);
	        	con_d_name=rs.getString(3);
	        	description=rs.getString(4);
	        	image=rs.getString(5);
	        	votes=rs.getInt(6);
	        	list.add(new Vote_result_bean(con_d_id,con_d_name,description,image,votes));
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
	public Vote_result_Info_Bean result1(String con_id){
		Vote_result_Info_Bean list=new Vote_result_Info_Bean();
	    String con_d_id;
		String con_d_name;
		String description;
		String image;
		int votes;
		
		try{
			super.connection();
			String sql = "SELECT * from `contents_details` where con_id=?;";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, con_id);

	        rs = stmt.executeQuery();
	        while(rs.next()){
	        	con_d_id=rs.getString(1);
	        	con_d_name=rs.getString(3);
	        	description=rs.getString(4);
	        	image=rs.getString(5);
	        	votes=rs.getInt(6);
	        	list.addList(new Vote_result_bean(con_d_id,con_d_name,description,image,votes));
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
