package NewRestAssured.NewRestAssured.Pojo.Pojo;

import java.util.List;

import NewRestAssured.NewRestAssured.Pojo.ChildPojo;

public class MainPojo {
	private ChildMainPojo location;
	private int accuracy;
	private String name;
	private String phone_number;
	private List<String> types;
	private String website;
	private String language;
	
	public ChildMainPojo getLocation() {
		return location;
	}
	public void setLocation(ChildMainPojo location) {
		this.location = location;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}

}
