package uo.asw.agents.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uo.asw.model.Agente;

public class AgenteTest {
	
	
	@Test
	public void agenteTest() {
		Agente a1 = new Agente("nombre1", "contraseña1", "person", "identificador1", 
				"latitud1", "longitud1", "email1@prueba.es", "si");
		
		assertEquals("nombre1", a1.getNombre());
		assertEquals("contraseña1", a1.getContrasena());
		assertEquals("person", a1.getKind());
		assertEquals("identificador1", a1.getIdentificador());
		assertEquals("latitud1", a1.getLatitud());
		assertEquals("longitud1", a1.getLongitud());
		assertEquals("email1@prueba.es", a1.getEmail());
		assertEquals("si", a1.getPermisoEnvio());
		
		a1.setPermisoEnvio("no");
		assertEquals("no", a1.getPermisoEnvio());
		
		
	}

}
