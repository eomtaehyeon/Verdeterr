package com.board.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPwHint() {
		return pwHint;
	}

	public void setPwHint(String pwHint) {
		this.pwHint = pwHint;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isManagerYn() {
		return managerYn;
	}

	public void setManagerYn(boolean managerYn) {
		this.managerYn = managerYn;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	/** 아이디 (PK) */
	private String id;

	/** 비밀번호 */
	private String pw;

	/** 비밀번호힌트 */
	private String pwHint;

	/** 이메일 */
	private String email;

	/** 유형 */
	private String userType;

	/** 닉네임 */
	private String nickname;

	/** 나이 */
	private int age;

	/** 성별 */
	private String gender;

	/** 관리자여부 */
	private boolean managerYn;

	/** 가입일자 */
	private LocalDateTime regDate;

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", pw=" + pw + ", pwHint=" + pwHint + ", email=" + email + ", userType=" + userType
				+ ", nickname=" + nickname + ", age=" + age + ", gender=" + gender + ", managerYn=" + managerYn
				+ ", regDate=" + regDate + "]";
	}



}