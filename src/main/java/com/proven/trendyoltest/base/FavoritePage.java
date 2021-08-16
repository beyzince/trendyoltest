package com.proven.trendyoltest.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FavoritePage {

    private WebDriver driver;

    public FavoritePage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://www.trendyol.com/Hesabim/Favoriler");
    }

    public void removeElementFromFavorite(int index) {
        driver.findElements(By.cssSelector("div.favored-product-container"))
                .get(index)
                .findElement(By.cssSelector("div.ufvrt-btn-wrppr"))
                .click();
    }

}
