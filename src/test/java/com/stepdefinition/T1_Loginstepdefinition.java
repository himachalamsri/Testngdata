package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.base.Baseclass;
import com.pom.Pageobjectmanager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class T1_Loginstepdefinition extends Baseclass {
	
	Pageobjectmanager pom=new Pageobjectmanager();

	@Given("user is on the login page")
	public void user_is_on_the_login_page() throws FileNotFoundException, IOException {
	   getdriver(getpropertyvalue("browser"));
	   getUrl(getpropertyvalue("url"));
	   maximizewindow();
	   
	}
	@When("user login {string},{string}")
	public void user_login(String username, String password) {
	    pom.getLoginpage().login(username, password);
	}
	@Then("user should verify success message after login {string}")
	public void user_should_verify_success_message_after_login(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


	@When("user login {string},{string} using ENTER key")
	public void user_login_using_enter_key(String username, String password) {
	   pom.getLoginpage().loginwithenterkey(username, password);
	}

	
	@Then("user should verify error message after login {string}")
	public void user_should_verify_error_message_after_login(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}







	
	
	
	
	
}
