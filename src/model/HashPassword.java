package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPassword {
	
	/**
	* 文字列をハッシュ化するメソッド
	*
	* @param pass ハッシュ化するテキスト
	*
	* @return ハッシュ化した計算値(16進数)
	*/
	public String encryptPass(String pass) {
	    // 変数初期化
	    MessageDigest md = null;
	    StringBuffer buffer = new StringBuffer();

	    try {
	        // メッセージダイジェストインスタンス取得
	        md = MessageDigest.getInstance("SHA-256");
	    } catch (NoSuchAlgorithmException e) {
	        // 例外発生時、エラーメッセージ出力
	        System.out.println("指定された暗号化アルゴリズムがありません");
	    }

	    // メッセージダイジェスト更新
	    md.update(pass.getBytes());

	    // ハッシュ値を格納
	    byte[] valueArray = md.digest();

	    // ハッシュ値の配列をループ
	    for(int i = 0; i < valueArray.length; i++){
	        // 値の符号を反転させ、16進数に変換
	        String tmpStr = Integer.toHexString(valueArray[i] & 0xff);

	        if(tmpStr.length() == 1){
	            // 値が一桁だった場合、先頭に0を追加し、バッファに追加
	            buffer.append('0').append(tmpStr);
	        } else {
	            // その他の場合、バッファに追加
	            buffer.append(tmpStr);
	        }
	    }

	    // 完了したハッシュ計算値を返却
	    return buffer.toString();
	}

}
