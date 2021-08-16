package com.proven.trendyoltest.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class BaseTests {
    protected WebDriver driver;

    public static WebDriverWait wait;

    private FirefoxDriver firefoxDriver;
    private EdgeDriver edgeDriver;
    private String browser = "chrome";



    @BeforeEach
    public void setUp() {
        System.out.println("Setup driver...");
        if(browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src" + File.separator + "main" + File.separator + "resources" + File.separator +"geckodriver");

            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "src" + File.separator + "main" + File.separator + "resources" + File.separator +"chromedriver");
            Map<String, Object> prefs= new HashMap<>();
            prefs.put("profile.default_content_setting_values.cookies",2);
            prefs.put("network.cookie.cookieBehavior",2);
            prefs.put("profile.block_third_party_cookies",true);
            ChromeOptions options= new ChromeOptions();
            options.setExperimentalOption("prefs",prefs);
            driver= new ChromeDriver();
            System.out.println("Create chrome driver");
        }
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 30);

        /*

        else if(browser.equalsIgnoreCase("edge")){
                System.setProperty("webdriver.edge.driver", "src" + File.separator + "main" + File.separator + "resources" + File.separator +"chromedriver");
                driver= new EdgeDriver();


         */

        driver.get("https://www.trendyol.com/giris");



        String ActualTitle=driver.getTitle();

        String ExpectedTitle="En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da";

        Assert.assertEquals(ExpectedTitle,ActualTitle);

    }
    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
