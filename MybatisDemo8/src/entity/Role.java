package entity;

import java.util.List;

public class Role {
	private int rid;
	private String rname;
	List<User> users;
	
	
	public Role() {
	}


	public Role(int rid, String rname, List<User> users) {
		this.rid = rid;
		this.rname = rname;
		this.users = users;
	}


	public int getRid() {
		return rid;
	}


	public void setRid(int rid) {
		this.rid = rid;
	}


	public String getRname() {
		return rname;
	}


	public void setRname(String rname) {
		this.rname = rname;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	@Override
	public String toString() {
		return "Role [rid=" + rid + ", rname=" + rname + ", users=" + users + "]";
	}
	
}
