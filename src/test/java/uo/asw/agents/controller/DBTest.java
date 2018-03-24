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
import uo.asw.dbManagement.LoaderDAO;
import uo.asw.dbManagement.model.Agent;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration

public class DBTest {

	
	@Autowired
    private LoaderDAO loaderDAO;
	
	@Test
    public void getExistingAgent() throws Exception {
    	Agent c1 = loaderDAO.getAgent("juan", "1234", "person");
    	Agent c2 = loaderDAO.getAgent("pedro", "1234", "sensor");
    	Agent c3 = loaderDAO.getAgent("raul", "1234", "entity");

		/*assertEquals("juan", c1.getNombreUsuario());
		assertEquals("1234", c1.getContraseña());
		assertEquals("person", c1.getKind());
		
		assertEquals("pedro", c2.getNombreUsuario());
		assertEquals("1234", c2.getContraseña());
		assertEquals("sensor", c2.getKind());
		
		assertEquals("raul", c3.getNombreUsuario());
		assertEquals("1234", c3.getContraseña());
		assertEquals("entity", c3.getKind());
		*/
    }
    
    @Test
    public void getNonExistingAgent() throws Exception {
    	Agent c1 = loaderDAO.getAgent("antonio", "1234", "entity");
    	Agent c2 = loaderDAO.getAgent("daniel", "1234", "sensor");
    	Agent c3 = loaderDAO.getAgent("rodrigo", "1234", "person");

    	assertNull(c1);
    	assertNull(c2);
    	assertNull(c3);

     }
    
    @Test
    public void wrongPasswordTest() throws Exception {
    	
    	Agent c1 = loaderDAO.getAgent("juan", "password", "person");
    	Agent c2 = loaderDAO.getAgent("pedro", "password", "entity");
    	Agent c3 = loaderDAO.getAgent("raul", "password", "sensor");
    	
    	assertNull(c1);
    	assertNull(c2);
    	assertNull(c3);
    }
    
    @Test
    public void wrongUserNameTest() throws Exception {
    	
    	Agent c1 = loaderDAO.getAgent("juan@gmail.com", "1234", "person");
    	Agent c2 = loaderDAO.getAgent("pedro@gmail.com", "1234", "entity");
    	Agent c3 = loaderDAO.getAgent("raul@gmail.com", "1234", "sensor");
    	
    	assertNull(c1);
    	assertNull(c2);
    	assertNull(c3);
    }
    
    @Test
    public void wrongUserTypeTest() throws Exception {
    	
    	Agent c1 = loaderDAO.getAgent("juan", "1234", "entity");
    	Agent c2 = loaderDAO.getAgent("pedro", "1234", "person");
    	Agent c3 = loaderDAO.getAgent("raul", "1234", "sensor");
    	
    	assertNull(c1);
    	assertNull(c2);
    	assertNull(c3);
    }
    
    @Test
    public void updateTest() throws Exception {
    	
    	Agent c1 = loaderDAO.getAgent("juan", "1234", "person");
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