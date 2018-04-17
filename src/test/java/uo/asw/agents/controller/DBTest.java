package uo.asw.agents.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import uo.asw.Application;
import uo.asw.model.Agente;
import uo.asw.repository.AgentsRepository;
import uo.asw.services.AgentsService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration

public class DBTest {

	
	@Autowired
    private AgentsRepository agentsRepository;
	
	@Autowired 
	private AgentsService agentsService;
	
	@Test
    public void getExistingAgent() throws Exception {
    	Agente c1 = agentsRepository.findByNombreAndContrasenaAndKind("juan", "1234", "person");
    	Agente c2 = agentsRepository.findByNombreAndContrasenaAndKind("pedro", "1234", "sensor");
    	Agente c3 = agentsRepository.findByNombreAndContrasenaAndKind("raul", "1234", "entity");

		assertEquals("juan", c1.getNombre());
		assertEquals("1234", c1.getContrasena());
		assertEquals("person", c1.getKind());
		
		assertEquals("pedro", c2.getNombre());
		assertEquals("1234", c2.getContrasena());
		assertEquals("sensor", c2.getKind());
		
		assertEquals("raul", c3.getNombre());
		assertEquals("1234", c3.getContrasena());
		assertEquals("entity", c3.getKind());
		
    }
    
    @Test
    public void getNonExistingAgent() throws Exception {
    	Agente c1 = agentsRepository.findByNombreAndContrasenaAndKind("antonio", "1234", "entity");
    	Agente c2 = agentsRepository.findByNombreAndContrasenaAndKind("daniel", "1234", "sensor");
    	Agente c3 = agentsRepository.findByNombreAndContrasenaAndKind("rodrigo", "1234", "person");

    	assertNull(c1);
    	assertNull(c2);
    	assertNull(c3);

     }
    
    @Test
    public void wrongPasswordTest() throws Exception {
    	
    	Agente c1 = agentsRepository.findByNombreAndContrasenaAndKind("juan", "password", "person");
    	Agente c2 = agentsRepository.findByNombreAndContrasenaAndKind("pedro", "password", "entity");
    	Agente c3 = agentsRepository.findByNombreAndContrasenaAndKind("raul", "password", "sensor");
    	
    	assertNull(c1);
    	assertNull(c2);
    	assertNull(c3);
    }
    
    @Test
    public void wrongUserNameTest() throws Exception {
    	
    	Agente c1 = agentsRepository.findByNombreAndContrasenaAndKind("juan@gmail.com", "1234", "person");
    	Agente c2 = agentsRepository.findByNombreAndContrasenaAndKind("pedro@gmail.com", "1234", "entity");
    	Agente c3 = agentsRepository.findByNombreAndContrasenaAndKind("raul@gmail.com", "1234", "sensor");
    	
    	assertNull(c1);
    	assertNull(c2);
    	assertNull(c3);
    }
    
    @Test
    public void wrongUserTypeTest() throws Exception {
    	
    	Agente c1 = agentsRepository.findByNombreAndContrasenaAndKind("juan", "1234", "entity");
    	Agente c2 = agentsRepository.findByNombreAndContrasenaAndKind("pedro", "1234", "person");
    	Agente c3 = agentsRepository.findByNombreAndContrasenaAndKind("raul", "1234", "sensor");
    	
    	assertNull(c1);
    	assertNull(c2);
    	assertNull(c3);
    }
    
    @Test
    public void updateTest() throws Exception {
    	
    	Agente c1 = agentsRepository.findByNombreAndContrasenaAndKind("juan", "1234", "person");
    	
    	//Cambio de contraseña
    	c1.setContrasena("new password");
    	agentsService.addAgente(c1);
       
       	assertEquals("new password", c1.getContrasena());
       	
       	//Cambio de contraseña por la original
       	c1.setContrasena("1234");
       	agentsService.addAgente(c1);
       	
       	assertEquals("1234", c1.getContrasena());
	
        	
    }
    
    @Test
    public void dbTest() throws Exception {
    	Agente a1 = new Agente("nombre1", "contraseña1", "person", "identificador1", 
				"latitud1", "longitud1", "email1@prueba.es", "si");
    	agentsService.addAgente(a1);
    	
    	Agente a2 = agentsRepository.findByNombreAndContrasenaAndKind("nombre1", 
    			"contraseña1", "person");
    	assertEquals(a1.getNombre(), a2.getNombre());
    	assertEquals(a1.getContrasena(), a2.getContrasena());
    	assertEquals(a1.getKind(), a2.getKind());
    	
    	agentsService.deleteAgente(a1);
    	
    	a2 = agentsRepository.findByNombreAndContrasenaAndKind("nombre1", 
    			"contraseña1", "person");
    	
    	assertNull(a2);
    	
    }

}