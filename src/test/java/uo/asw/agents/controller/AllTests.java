package uo.asw.agents.controller;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	
	LoaderControllerTest.class,
	DBTest.class,
	UtilTest.class,
	WebControllerTest.class
})
public class AllTests { }
