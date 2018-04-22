package uo.asw.agents.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
		
		a1.setNombre("nombre2");
		assertEquals("nombre2", a1.getNombre());
		
		a1.setContrasena("contraseña2");
		assertEquals("contraseña2", a1.getContrasena());
		
		a1.setKind("sensor");
		assertEquals("sensor", a1.getKind());
		
		a1.setIdentificador("identificador2");
		assertEquals("identificador2", a1.getIdentificador());
		
		a1.setLatitud("latitud2");
		assertEquals("latitud2", a1.getLatitud());
		
		a1.setEmail("email2@prueba.es");
		assertEquals("email2@prueba.es", a1.getEmail());
		
		a1.setLongitud("longitud2");
		assertEquals("longitud2", a1.getLongitud());
		
		Agente a2 = a1;
		assertTrue(a1.equals(a2));
		
		String s1 = a1.toString();
		String s2 = a2.toString();
		
		assertTrue(s1.equals(s2));
		
			
	}
	
}
