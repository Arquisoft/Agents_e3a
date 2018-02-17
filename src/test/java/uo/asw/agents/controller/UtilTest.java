package uo.asw.agents.controller;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.datetime.joda.LocalDateParser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import uo.asw.Application;
import uo.asw.agents.util.Check;
import uo.asw.agents.util.LoaderMin;
import uo.asw.agents.util.DateUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class UtilTest {

	
	private static String[] validEmails, invalidEmails;
	private LoaderMin loaderMin;
	
	 /**
     * Carga de datos
     */
    @BeforeClass
    public static void emailProviderText() {
        validEmails = new String[] { "test@example.com",
                "test-101@example.com", "test.101@yahoo.com",
                "test101@example.com", "test_101@example.com",
                "test-101@test.net", "test.100@example.com.au", "test@e.com",
                "test@1.com", "test@example.com.com", "test+101@example.com",
                "101@example.com", "test-101@example-test.com" };
 
        invalidEmails = new String[] { "example", "example@.com.com",
                "exampel101@test.a", "exampel101@.com", ".example@test.com",
                "example**()@test.com", "example@%*.com",
                "example..101@test.com", "example.@test.com",
                "test@example_101.com", "example@test@test.com",
                "example@test.com.a5" };
    }
	
	
    @Before
    public void setUp() throws Exception {
    	loaderMin = new LoaderMin("nombre", "apellido", new Date(),(long) 1,"kind","kindCode", "usuario@gmail.com");
    }

	@Test
	public void newCitizenMinTest() {
		
		Long id = (long) 2;
		String nombre = "fernando";
		String apellidos = "sanchez";
		Date fechaNacimiento = new Date();
		int edad = DateUtil.getYears(fechaNacimiento);
		String email = "fernando@gmail.com";

		loaderMin.setId(id);
		loaderMin.setFirstName(nombre);
		loaderMin.setLastName(apellidos);
		loaderMin.setEdad(edad);
		loaderMin.setEmail(email);

	
		assertEquals(id, loaderMin.getId());
		assertEquals(nombre, loaderMin.getFirstName());
		assertEquals(apellidos, loaderMin.getLastName());
		assertEquals(edad, loaderMin.getEdad());
		assertEquals(email, loaderMin.getEmail());
		
	}
	
	
	@Test
	public void dateUtilTest() throws ParseException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		
		//Ya ha cumplido años
		String dateString1 = "10-02-1990";
		Date date1 = formatter.parse(dateString1);
		int edad1 = DateUtil.getYears(date1);
	    int d1 = Integer.parseInt(formatter.format(date1));
	    int d2 = Integer.parseInt(formatter.format(Calendar.getInstance().getTime()));
	    int age = (d2-d1)/10000;
		assertEquals(age, edad1);

		//Aun no ha cumplido años
		String dateString2 = "10-08-1990";
		Date date2 = formatter.parse(dateString2);
		int edad2 = DateUtil.getYears(date2);
	    int d3 = Integer.parseInt(formatter.format(date2));
	    int d4 = Integer.parseInt(formatter.format(Calendar.getInstance().getTime()));
	    int age2 = (d4-d3)/10000;
		assertEquals(age2, edad2);
	}
	
	@Test
	public void checkTest(){
		
		assertTrue(Check.validateEmail("juan@gmail.com"));
		assertTrue(Check.validateEmail("juan@uniovi.es"));
		
		assertFalse(Check.validateEmail("usuario"));
		assertFalse(Check.validateEmail("usuario@gmail"));
		assertFalse(Check.validateEmail("usuario.com"));

	}
	
	
	 
 
    /**
     * Test para email valido
     */
    @Test
    public void validEmailTest() {
 
        for (String temp : validEmails) {
 
            assertTrue(Check.validateEmail(temp));
        }
 
    }
 
    /**
     * Test para email no valido
     */
    @Test
    public void invalidEmailTest() {
 
        for (String temp : invalidEmails) {
 
          assertFalse(Check.validateEmail(temp));
        }
 
    }
}
