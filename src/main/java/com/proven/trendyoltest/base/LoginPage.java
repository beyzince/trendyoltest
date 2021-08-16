package com.proven.trendyoltest.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By mailField= By.id("login-email");
    private  By passwordField=By.id("login-password-input");
    private  By  loginButton= By.cssSelector("#login-register > div.lr-container > div.login > form > button");




    public LoginPage(WebDriver driver) {
        this.driver=driver;


    }


    public  void setMail(String mail){
        driver.findElement(mailField).sendKeys(mail);
    }
    public  void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
        System.out.println("try to click");
    }


}
