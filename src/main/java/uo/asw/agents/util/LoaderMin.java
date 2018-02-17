package uo.asw.agents.util;



public class LoaderMin {

	private String name;
	//private String lastName;
	private Long id;
	private String location;
	private String email;
	//private int edad;
	private String kind;
	private String kindCode;
	
	
	
	public LoaderMin(String name, Long id,String location,  String email,
			String kind, String kindCode) {
		super();
		this.name = name;
//		this.lastName = lastName;
//		this.edad = DateUtil.getYears(fechaNacimiento);
		this.id = id;
		this.location = location;
		this.email = email;
		this.kind = kind;
		this.kindCode = kindCode; 
	}
	


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
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
		return "LoaderMin [name=" + name + ", id=" + id + ", location=" + location + ", email=" + email + ", kind="
				+ kind + ", kindCode=" + kindCode + "]";
	}






	
	
	
	
	
	
	
	
}
