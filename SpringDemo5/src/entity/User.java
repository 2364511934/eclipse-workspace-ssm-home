package entity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class User {
	private int id;
	private String name;
	private String[] data;
	private List listData;
	private Set setData;
	private Map mapData;
	private Properties pros;
	
	
	public User() {
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String[] getData() {
		return data;
	}


	public void setData(String[] data) {
		this.data = data;
	}


	public List getListData() {
		return listData;
	}


	public void setListData(List listData) {
		this.listData = listData;
	}


	public Set getSetData() {
		return setData;
	}


	public void setSetData(Set setData) {
		this.setData = setData;
	}


	public Map getMapData() {
		return mapData;
	}


	public void setMapData(Map mapData) {
		this.mapData = mapData;
	}


	public Properties getPros() {
		return pros;
	}


	public void setPros(Properties pros) {
		this.pros = pros;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", data=" + Arrays.toString(data) + ", listData=" + listData
				+ ", setData=" + setData + ", mapData=" + mapData + ", pros=" + pros + "]";
	}
	
}
