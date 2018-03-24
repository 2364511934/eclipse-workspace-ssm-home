package entity;

import java.util.Arrays;

public class User {
	String user;
	String pwd;
	String[] hobby;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String user, String pwd, String[] hobby) {
		super();
		this.user = user;
		this.pwd = pwd;
		this.hobby = hobby;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "User [user=" + user + ", pwd=" + pwd + ", hobby=" + Arrays.toString(hobby) + "]";
	}

}
