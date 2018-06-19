package dao;

public class PassWordDao extends DaoBase {

	public PassWordDao() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	//パスワードのハッシュ化
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

	public  boolean LoginUser(String userid,String pass) {

		boolean flg = false;
		try {
			// connection確立
			super.connection();

			// ユーザーを登録するSQL
			String SQL = "SELECT * FROM password WHERE user_id=? and password=?";

			stmt = con.prepareStatement(SQL);
			// SQLの？に値のセット
			stmt.setString(1, userid);
			stmt.setString(2, pass);
			rs = stmt.executeQuery();

			rs.next();
			if(rs!=null) {
				flg = true;
			}else {
				flg = false;
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
