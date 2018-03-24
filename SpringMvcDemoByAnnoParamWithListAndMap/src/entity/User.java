package entity;

import java.util.List;
import java.util.Map;

public class User {
	private String user;
	private String pwd;
	private List<String> lists;
	private Map maps;    // 使用隐士类型 显示类型貌似不可以?????
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String user, String pwd, List<String> lists, Map maps) {
		super();
		this.user = user;
		this.pwd = pwd;
		this.lists = lists;
		this.maps = maps;
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
	public List<String> getLists() {
		return lists;
	}
	public void setLists(List<String> lists) {
		this.lists = lists;
	}
	public Map getMaps() {
		return maps;
	}
	public void setMaps(Map maps) {
		this.maps = maps;
	}
	@Override
	public String toString() {
		return "User [user=" + user + ", pwd=" + pwd + ", lists=" + lists + ", maps=" + maps + "]";
	}

}
