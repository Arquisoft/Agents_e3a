package Agents.uo.asw.agents.util;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@XmlRootElement(name = "min")
@JsonPropertyOrder({ "name", "location", "email", "id", "kind", "kindCode" })
public class LoaderMin {

	private String name;
	private String id;
	private String location;
	private String email;
	private String kind;
	private String kindCode;
	
	
	
	public LoaderMin(String name, String location,  String email, String id,
			String kind, String kindCode) {
		super();
		this.name = name;
		this.location = location;
		this.email = email;
		this.id = id;
		this.kind = kind;
		this.kindCode = kindCode; 
	}
	


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getKind() {
		return kind;
	}



	public void setKind(String kind) {
		this.kind = kind;
	}



	public String getKindCode() {
		return kindCode;
	}



	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}



	@Override
	public String toString() {
		return "LoaderMin [name=" + name + ", location=" + location + ", email=" + email + ", id=" + id + ", kind="
				+ kind + ", kindCode=" + kindCode + "]";
	}






	
	
	
	
	
	
	
	
}
