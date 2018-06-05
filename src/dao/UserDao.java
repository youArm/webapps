package dao;

import model.UserBean;

public class UserDao extends DaoBase {

	public UserDao() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	// ユーザ登録
	public void registrationUser(UserBean ubean) {
		System.out.println("*****００００");
		try {

			// connection確立
			super.connection();

			// ユーザーを登録するSQL
			String sql = "insert into user(user_id,name,gender,birth_year,birth_month,birth_day,prefectures,question_id,answer) values(?,?,?,?,?,?,?,?,?)";

			stmt = con.prepareStatement(sql);

			System.out.println("*****");

			// SQLの？に値のセット
			stmt.setString(1, ubean.getUserId());
			stmt.setString(2, ubean.getNickname());
			stmt.setString(3, ubean.getGender());
			stmt.setInt(4, ubean.getBirthYear());
			stmt.setInt(5, ubean.getBirthMonth());
			stmt.setInt(6, ubean.getBirthDay());
			stmt.setString(7, ubean.getPrefectures());
			stmt.setString(8, ubean.getQuestionId());
			stmt.setString(9, ubean.getAnswer());
			stmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("*****11111");
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

	// 会員登録時のユーザID重複チェック
	public boolean userIDcheck(String userid) {

		boolean flg = false;

		try {
			// connection確立
			super.connection();

			String selectSQL = "select userid from user where userid = ?";

			stmt = con.prepareStatement(selectSQL);
			// SQLの？に値のセット
			stmt.setString(1, userid);
			rs = stmt.executeQuery();
			
			rs.next();
			
			System.out.println("aaaaa");
			
			if (rs != null) {
				flg = true;
			} else {
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
