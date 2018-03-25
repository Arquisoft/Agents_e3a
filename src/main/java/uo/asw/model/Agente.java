package uo.asw.model;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "agents")
public class Agente {
	@Id
	private ObjectId id;
	
	private String nombre;
	private String contrasena;
	private String kindCode;
	private String kind;
	
	@NotNull
	@Column(unique = true)
	private String identificador;
	private String latitud;
	private String longitud;
	private String email;
	
	@Column(name = "permiso_envio")
	private String permisoEnvio; //'si' o 'no'
	
	public Agente() {}

	public Agente(String nombre, String contrasena, String kind, String identificador, String latitud,
			String longitud, String email, String permisoEnvio) {
		super();
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.kind = kind;
		this.identificador = identificador;
		this.latitud = latitud;
		this.longitud = longitud;
		this.email = email;
		this.permisoEnvio = permisoEnvio;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	
	public String getKindCode() {
		return kindCode;
	}

	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPermisoEnvio() {
		return permisoEnvio;
	}

	public void setPermisoEnvio(String permisoEnvio) {
		this.permisoEnvio = permisoEnvio;
	}

	


	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((identificador == null) ? 0 : identificador.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agente other = (Agente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (identificador == null) {
			if (other.identificador != null)
				return false;
		} else if (!identificador.equals(other.identificador))
			return false;
		return true;
	}



	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	
	

}
