package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Baseclass;

public class Loginpage extends Baseclass {
	
	
	public  Loginpage() {
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(id="email")
	private WebElement textusername;
	@FindBy(id="pass")
	private WebElement textpassword;
	@FindBy(name="login")
	private WebElement loginbtn;
	
	
	public WebElement getTextusername() {
		return textusername;
	}
	public WebElement getTextpassword() {
		return textpassword;
	}
	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	
	public void login(String username,String password) {
		sendkeys(getTextusername(), username);
		sendkeys(getTextpassword(), password);
		clickbutton(getLoginbtn());
	}
	
	public void loginwithenterkey(String username,String password) {
		sendkeys(getTextusername(), username);
		sendkeysEnter(getTextpassword(), password);

	}
	
	

}
