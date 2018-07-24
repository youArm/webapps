package dao;

import java.util.ArrayList;

import model.ContentsBean;

public class ContentsDao extends DaoBase{

	public int countContents() {
		try {

			// connection確立
			super.connection();

			// ユーザーを登録するSQL
			String sql = "select count(*) from contents";

			stmt = con.prepareStatement(sql);

			rs = stmt.executeQuery();


			rs.next();
			rsno = rs.getInt(1);

			System.out.println(rsno);

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
		return rsno;
	}

	public void registrationContents(String user, String catename,String conname,String date, String contentsId, String createDate) {
		try {

			// connection確立
			super.connection();

			// ユーザーを登録するSQL
			String sql = "insert into contents(con_id,user_id,cate_id,con_name,create_date,end_date) values(?,?,?,?,?,?)";

			stmt = con.prepareStatement(sql);

			// SQLの？に値のセット
			stmt.setString(1, contentsId);
			stmt.setString(2, user);
			stmt.setString(3, catename);
			stmt.setString(4, conname);
			stmt.setString(5, createDate);
			stmt.setString(6, date);

			stmt.executeUpdate();

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