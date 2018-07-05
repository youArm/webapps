package dao;

public class PassWordDao extends DaoBase {

	public PassWordDao() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	//パスワードの登録
	public void registrationPassword(String userid,String pass) {
		try {
			// connection確立
			super.connection();

			// ユーザーを登録するSQL
			String insertSQL = "insert into password values(?,?)";

			stmt = con.prepareStatement(insertSQL);
			// SQLの？に値のセット
			stmt.setString(1, userid);
			stmt.setString(2, pass);
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
	
	public void UpdatePass(String userid,String pass){
		try {
			// connection確立
			super.connection();

			// ユーザーを登録するSQL
			String SQL = "UPDATE password SET password = ? WHERE user_id = ?";

			stmt = con.prepareStatement(SQL);
			// SQLの？に値のセット
			stmt.setString(1, pass);
			stmt.setString(2, userid);
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

	public  boolean LoginUser(String userid,String pass) {

		boolean flg = false;
		try {
			// connection確立
			super.connection();

			// ユーザーを登録するSQL
			String SQL = "SELECT * FROM password WHERE user_id = ? and password = ?";

			stmt = con.prepareStatement(SQL);
			// SQLの？に値のセット
			stmt.setString(1, userid);
			stmt.setString(2, pass);
			rs = stmt.executeQuery();
			
			while(rs.next()){
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
}
