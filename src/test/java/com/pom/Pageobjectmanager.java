package com.pom;

import com.pages.Loginpage;

public class Pageobjectmanager{
	
	
	private Loginpage loginpage;

	public Loginpage getLoginpage() {
		return (loginpage==null)?loginpage=new Loginpage():loginpage;
	}
	
	
	

	
	
	

}
