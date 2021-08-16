package com.proven.trendyoltest.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.regex.Pattern;

public class SearchPage {
    private  WebDriver driver;
    private  By  inputField= By.cssSelector("#auto-complete-app input");
    private By selectedElement = By.cssSelector("div.suggestion-result > a");
    private By productContainers = By.cssSelector("div.prdct-cntnr-wrppr");

    public SearchPage(WebDriver driver) {
        this.driver=driver;
    }


    public void enterText(String text){
        driver.findElement(inputField).sendKeys(text);
    }

    public void selectElement(int index) {
        driver.findElements(selectedElement).get(index).click();
    }

    public void addProductToFavorite(int index) {
        WebElement fav = driver.findElements(productContainers)
                .get(index)
                .findElement(By.cssSelector("div.fvrt-btn-wrppr"));
        try {
            fav.click();
        } catch (Exception e) {
            driver.findElement(By.cssSelector("div.overlay")).click();
            fav.click();
        }

    }


}
