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
import uo.asw.dbManagement.model.Loader;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration

public class DBTest {

	
	@Autowired
    private LoaderDAO loaderDAO;
	
	@Test
    public void getExistingCitizen() throws Exception {
    	Loader c1 = loaderDAO.getAgents("juan", "1234");
    	Loader c2 = loaderDAO.getAgents("pedro", "1234");
    	Loader c3 = loaderDAO.getAgents("raul", "1234");

		assertEquals("juan", c1.getNombreUsuario());
		assertEquals("1234", c1.getContraseña());
		
		assertEquals("pedro", c2.getNombreUsuario());
		assertEquals("1234", c2.getContraseña());
		
		assertEquals("raul", c3.getNombreUsuario());
		assertEquals("1234", c3.getContraseña());
    }
    
    @Test
    public void getNonExistingCitizen() throws Exception {
    	Loader c1 = loaderDAO.getAgents("antonio", "1234");
    	Loader c2 = loaderDAO.getAgents("daniel", "1234");
    	Loader c3 = loaderDAO.getAgents("rodrigo", "1234");

    	assertNull(c1);
    	assertNull(c2);
    	assertNull(c3);

     }
    
    @Test
    public void wrongPasswordTest() throws Exception {
    	
    	Loader c1 = loaderDAO.getAgents("juan", "password");
    	Loader c2 = loaderDAO.getAgents("pedro", "password");
    	Loader c3 = loaderDAO.getAgents("raul", "password");
    	
    	assertNull(c1);
    	assertNull(c2);
    	assertNull(c3);
    }
    
    @Test
    public void wrongUserPasswordTest() throws Exception {
    	
    	Loader c1 = loaderDAO.getAgents("juan@gmail.com", "password");
    	Loader c2 = loaderDAO.getAgents("pedro@gmail.com", "password");
    	Loader c3 = loaderDAO.getAgents("raul@gmail.com", "password");
    	
    	assertNull(c1);
    	assertNull(c2);
    	assertNull(c3);
    }
    
    @Test
    public void updateTest() throws Exception {
    	
    	Loader c1 = loaderDAO.getAgents("juan", "1234");
    	
    	//Cambio de contraseña
    	c1.setContraseña("new password");
       	loaderDAO.updateInfo(c1);
       
       	assertEquals("new password", c1.getContraseña());
       	
       	//Cambio de contraseña por la original
       	c1.setContraseña("1234");
       	loaderDAO.updateInfo(c1);
       	
       	assertEquals("1234", c1.getContraseña());

        	
    }

}