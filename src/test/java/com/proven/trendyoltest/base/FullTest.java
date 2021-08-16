package com.proven.trendyoltest.base;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.regex.Pattern;

import static java.util.concurrent.TimeUnit.SECONDS;

public class FullTest extends BaseTests {

    @Test
    public void test() throws InterruptedException {
        testSuccessfulLogin();
        testSearch();
        testFavorite();
    }

    public void testSuccessfulLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        System.out.println("test succesfull login");
        loginPage.setMail("byzb060106@gmail.com");
        loginPage.setPassword("Bb1598756");
        loginPage.clickLoginButton();
        wait.until(ExpectedConditions.textToBe(By.cssSelector("div.account-user > p.link-text"), "Hesabım"));
    }

    public void testSearch() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.enterText("iphone");
        wait.until(ExpectedConditions.textToBe(By.cssSelector("div.suggestion-result-title > span"), "İlgili Sonuçlar"));
        searchPage.selectElement(1);
        wait.until(ExpectedConditions.textMatches(By.cssSelector("div.dscrptn"), Pattern.compile("sonuç listeleniyor", Pattern.CASE_INSENSITIVE)));
        searchPage.addProductToFavorite(0);
    }

    public void testFavorite() {
        FavoritePage favoritePage = new FavoritePage(driver);
        wait.until(ExpectedConditions.textMatches(By.cssSelector("div.header-left-section > a > span"), Pattern.compile("Favorilerim", Pattern.CASE_INSENSITIVE)));
        favoritePage.removeElementFromFavorite(0);
    }

}
