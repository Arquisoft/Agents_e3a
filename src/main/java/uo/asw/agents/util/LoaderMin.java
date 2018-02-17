package uo.asw.agents.util;

import java.util.Date;

public class LoaderMin {

	private String firstName;
	private String lastName;
	private int edad;
	private Long id;
	private String kind;
	private String kindCode;
	private String email;
	
	
	
	public LoaderMin(String firstName, String lastName, Date fechaNacimiento, Long id,
			String kind, String kindCode, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.edad = DateUtil.getYears(fechaNacimiento);
		this.id = id;
		this.email = email;
		this.kind = kind;
		this.kindCode = kindCode; 
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
		return "LoaderMin [firstName=" + firstName + ", lastName=" + lastName + ", edad=" + edad + ", id=" + id
				+ ", kind=" + kind + ", kindCode=" + kindCode + ", email=" + email + "]";
	}


	
	
	
	
	
	
	
	
}
