package dao;

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
		
}

