package dao;

import java.util.ArrayList;

import model.ContentsBean;
import model.ContentsDetailsBean;

public class ContentsDao extends DaoBase{

	public ContentsDao() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	//コンテンツ(アンケート)一覧取得
	public ArrayList<ContentsBean> getContentsList(){
		
		ArrayList<ContentsBean> contentsList = new ArrayList<ContentsBean>();
		
		try{
			super.connection();
			
			String sql = "SELECT * FROM contents";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				
				ContentsBean conBean = new ContentsBean();
				conBean.setConId(rs.getString(1));
				conBean.setUserId(rs.getString(2));
				conBean.setCateId(rs.getString(3));
				conBean.setConName(rs.getString(4));
				conBean.setCreateDate(rs.getDate(5));
				conBean.setCreateEnd(rs.getDate(6));
				conBean.setTotalVote(rs.getInt(7));
				
				contentsList.add(conBean);
				
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
		return contentsList;
	}
	
	//特定のコンテンツ(アンケート)の詳細を取得
	public ArrayList<ContentsDetailsBean> getContentsDetails(String conId){
		
		ArrayList<ContentsDetailsBean> contentsDetails = new ArrayList<ContentsDetailsBean>();
		
		try{
			super.connection();
			
			String sql = "SELECT * FROM contents_details WHERE con_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, conId);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				
				ContentsDetailsBean conDetailsBean = new ContentsDetailsBean();
				
				conDetailsBean.setCon_d_id(rs.getString(1));
				conDetailsBean.setCon_id(rs.getString(2));
				conDetailsBean.setCon_d_name(rs.getString(3));
				conDetailsBean.setDescription(rs.getString(4));
				conDetailsBean.setImage(rs.getString(5));
				conDetailsBean.setVotes(rs.getInt(6));
				
				contentsDetails.add(conDetailsBean);
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
		return contentsDetails;
	}
	
	//コンテンツ(アンケート)上位３つ取得
	public ArrayList<ContentsBean> getTopContentsList(){
		
		ArrayList<ContentsBean> contentsList = new ArrayList<ContentsBean>();
		
		try{
			super.connection();
			
			String sql = "SELECT * FROM contents ORDER BY total_vote limit 3";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				
				ContentsBean conBean = new ContentsBean();
				conBean.setConId(rs.getString(1));
				conBean.setUserId(rs.getString(2));
				conBean.setCateId(rs.getString(3));
				conBean.setConName(rs.getString(4));
				conBean.setCreateDate(rs.getDate(5));
				conBean.setCreateEnd(rs.getDate(6));
				conBean.setTotalVote(rs.getInt(7));
				
				contentsList.add(conBean);
				
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
		return contentsList;
	}
	
	//コンテンツ検索(ジャンル：全て以外、ワード指定)
	public ArrayList<ContentsBean> searchContents(String keyword,String cateId){
		
		ArrayList<ContentsBean> contentsList = new ArrayList<ContentsBean>();
		
		try{
			super.connection();
			
			String sql = "SELECT * FROM contents WHERE INSTR(con_name,?) <> 0 AND cate_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, keyword);
			stmt.setString(2, cateId);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				
				ContentsBean conBean = new ContentsBean();
				conBean.setConId(rs.getString(1));
				conBean.setUserId(rs.getString(2));
				conBean.setCateId(rs.getString(3));
				conBean.setConName(rs.getString(4));
				conBean.setCreateDate(rs.getDate(5));
				conBean.setCreateEnd(rs.getDate(6));
				conBean.setTotalVote(rs.getInt(7));
				
				contentsList.add(conBean);
				
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
		return contentsList;
	}
	//コンテンツ検索(ジャンル：全て、ワード指定)
	public ArrayList<ContentsBean> searchAllContents(String keyword){
		
		ArrayList<ContentsBean> contentsList = new ArrayList<ContentsBean>();
		
		try{
			super.connection();
			
			String sql = "SELECT * FROM contents WHERE INSTR(con_name,?) <> 0";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, keyword);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				
				ContentsBean conBean = new ContentsBean();
				conBean.setConId(rs.getString(1));
				conBean.setUserId(rs.getString(2));
				conBean.setCateId(rs.getString(3));
				conBean.setConName(rs.getString(4));
				conBean.setCreateDate(rs.getDate(5));
				conBean.setCreateEnd(rs.getDate(6));
				conBean.setTotalVote(rs.getInt(7));
				
				contentsList.add(conBean);
				
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
		return contentsList;
	}	
	
	public void contentsDelete(String conid){
		try{
			super.connection();
			
			String sql = "DELETE FROM contents WHERE con_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, conid);
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
	
	public ArrayList<ContentsBean> contentsHistory(String userid){
		
		ArrayList<ContentsBean> contentsList = new ArrayList<ContentsBean>();
		
		try{
			super.connection();
			
			String sql = "SELECT * FROM contents WHERE user_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, userid);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				
				ContentsBean conBean = new ContentsBean();
				conBean.setConId(rs.getString(1));
				conBean.setUserId(rs.getString(2));
				conBean.setCateId(rs.getString(3));
				conBean.setConName(rs.getString(4));
				conBean.setCreateDate(rs.getDate(5));
				conBean.setCreateEnd(rs.getDate(6));
				conBean.setTotalVote(rs.getInt(7));
				
				contentsList.add(conBean);
				
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
		return contentsList;
	}
}
