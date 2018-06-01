package dao;

import model.PassWordBean;

public class PassWordDao extends DaoBase {

	public PassWordDao() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	//パスワードのハッシュ化
	public void registrationPassword(PassWordBean passBean) {
		try {
			// connection確立
			super.connection();

			// ユーザーを登録するSQL
			String insertSQL = "insert into password values(?,?)";
			
			stmt = con.prepareStatement(insertSQL);
			// SQLの？に値のセット
			stmt.setString(1, passBean.getUserid());
			stmt.setString(2, passBean.getPass());
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
}
