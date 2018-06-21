package dao;

import model.UserBean;

public class UserDao extends DaoBase {

	public UserDao() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	// ユーザ登録
	public void registrationUser(UserBean ubean) {
		try {

			// connection確立
			super.connection();

			// ユーザーを登録するSQL
			String sql = "insert into user(user_id,name,gender,birth_year,birth_month,birth_day,prefectures,question_id,answer) values(?,?,?,?,?,?,?,?,?)";

			stmt = con.prepareStatement(sql);

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

			String selectSQL = "select count(*) from user where user_id = ?";

			stmt = con.prepareStatement(selectSQL);
			// SQLの？に値のセット
			stmt.setString(1, userid);
			rs = stmt.executeQuery();

			rs.next();

			if (rs.getInt(1) > 0) {
				flg = false;
			} else {
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
	
	//ユーザ情報変更
	
	public void updateUser(UserBean userbean){
		try {
			// connection確立
			super.connection();

			String updateSQL = "UPDATE user SET name = ?,gender = ?,birth_year = ?,birth_month = ?,birth_day = ?,prefectures = ?,question_id = ?,answer = ? WHERE userid = ?";
			
			stmt = con.prepareStatement(updateSQL);
			// SQLの？に値のセット
			stmt.setString(1, userbean.getNickname());
			stmt.setString(2, userbean.getGender());
			stmt.setInt(3, userbean.getBirthYear());
			stmt.setInt(4, userbean.getBirthMonth());
			stmt.setInt(5, userbean.getBirthDay());
			stmt.setString(6, userbean.getPrefectures());
			stmt.setString(7, userbean.getQuestionId());
			stmt.setString(8, userbean.getAnswer());
			stmt.setString(9, userbean.getUserId());
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

	public UserBean getUser(String user_id) {
		return null;
	}

}
