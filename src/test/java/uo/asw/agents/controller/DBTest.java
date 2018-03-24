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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration

public class DBTest {

	
	@Autowired
    private AgentsRepository loaderDAO;
	
	@Test
    public void getExistingAgent() throws Exception {
    	Agente c1 = loaderDAO.findByNombreAndContrasenaAndKind("juan", "1234", "person");
    	Agente c2 = loaderDAO.findByNombreAndContrasenaAndKind("pedro", "1234", "sensor");
    	Agente c3 = loaderDAO.findByNombreAndContrasenaAndKind("raul", "1234", "entity");

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
    	Agente c1 = loaderDAO.findByNombreAndContrasenaAndKind("antonio", "1234", "entity");
    	Agente c2 = loaderDAO.findByNombreAndContrasenaAndKind("daniel", "1234", "sensor");
    	Agente c3 = loaderDAO.findByNombreAndContrasenaAndKind("rodrigo", "1234", "person");

    	assertNull(c1);
    	assertNull(c2);
    	assertNull(c3);

     }
    
    @Test
    public void wrongPasswordTest() throws Exception {
    	
    	Agente c1 = loaderDAO.findByNombreAndContrasenaAndKind("juan", "password", "person");
    	Agente c2 = loaderDAO.findByNombreAndContrasenaAndKind("pedro", "password", "entity");
    	Agente c3 = loaderDAO.findByNombreAndContrasenaAndKind("raul", "password", "sensor");
    	
    	assertNull(c1);
    	assertNull(c2);
    	assertNull(c3);
    }
    
    @Test
    public void wrongUserNameTest() throws Exception {
    	
    	Agente c1 = loaderDAO.findByNombreAndContrasenaAndKind("juan@gmail.com", "1234", "person");
    	Agente c2 = loaderDAO.findByNombreAndContrasenaAndKind("pedro@gmail.com", "1234", "entity");
    	Agente c3 = loaderDAO.findByNombreAndContrasenaAndKind("raul@gmail.com", "1234", "sensor");
    	
    	assertNull(c1);
    	assertNull(c2);
    	assertNull(c3);
    }
    
    @Test
    public void wrongUserTypeTest() throws Exception {
    	
    	Agente c1 = loaderDAO.findByNombreAndContrasenaAndKind("juan", "1234", "entity");
    	Agente c2 = loaderDAO.findByNombreAndContrasenaAndKind("pedro", "1234", "person");
    	Agente c3 = loaderDAO.findByNombreAndContrasenaAndKind("raul", "1234", "sensor");
    	
    	assertNull(c1);
    	assertNull(c2);
    	assertNull(c3);
    }
    
    @Test
    public void updateTest() throws Exception {
    	
    	Agente c1 = loaderDAO.findByNombreAndContrasenaAndKind("juan", "1234", "person");
    	/*
    	//Cambio de contraseña
    	c1.setContraseña("new password");
       	loaderDAO.updateInfo(c1);
       
       	assertEquals("new password", c1.getContraseña());
       	
       	//Cambio de contraseña por la original
       	c1.setContraseña("1234");
       	loaderDAO.updateInfo(c1);
       	
       	assertEquals("1234", c1.getContraseña());
	*/
        	
    }

}