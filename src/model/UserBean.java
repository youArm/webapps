package model;

import java.io.Serializable;

public class UserBean implements Serializable {
	
	private String userId;
	private String nickname;
	private String gender;
	private int birthYear;
	private int birthMonth;
	private int birthDay;
	private String prefectures;
	private String questionId;
	private String answer;
	private String authority;
	
	public UserBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getBirthYear() {
		return birthYear;
	}
	
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	public int getBirthMonth() {
		return birthMonth;
	}
	
	public void setBirthMonth(int birthMonth) {
		this.birthMonth = birthMonth;
	}
	
	public int getBirthDay() {
		return birthDay;
	}
	
	public void setBirthDay(int birthDay) {
		this.birthDay = birthDay;
	}
	
	public String getPrefectures() {
		return prefectures;
	}
	
	public void setPrefectures(String prefectures) {
		this.prefectures = prefectures;
	}
	
	public String getQuestionId() {
		return questionId;
	}
	
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public String getAuthority() {
		return authority;
	}
	
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
}
