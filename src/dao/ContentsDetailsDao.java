package dao;

public class ContentsDetailsDao extends DaoBase {
	public void contentsDetails(String contentsId, String serialNumber, String detailName, String imagePathURL) {
		try {

			// connection確立
			super.connection();

			// detailsを登録するSQL
			String sql = ""
					+ "INSERT INTO contents_details(con_id, con_d_id, con_d_name, description, image) "
					+ "VALUES (?, ?, ?, '', ?)";

			stmt = con.prepareStatement(sql);

			// SQLの？に値のセット
			stmt.setString(1, contentsId);
			stmt.setString(2, serialNumber);
			stmt.setString(3, detailName);
			stmt.setString(4, imagePathURL);

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
