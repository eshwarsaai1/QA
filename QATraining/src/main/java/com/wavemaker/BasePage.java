package com.wavemaker;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class BasePage{
    ChromeDriver webDriver;
    private static final BasePage BASE_PAGE = new BasePage();

    public void launchBrowser(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("http://localhost:8080/LeavesManager/index.html");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static synchronized BasePage getInstance(){
        return BASE_PAGE;
    }

    public void write(By locator , String input){
        webDriver.findElement(locator).sendKeys(input);
    }

    public void click(By locator){
        webDriver.findElement(locator).click();
    }

    public void select(By locator, String value){
        Select select =new Select(webDriver.findElement(locator));
        select.selectByValue(value);
    }

    public void handleAlert(){
        Alert alert = webDriver.switchTo().alert();
        alert.accept();
    }

    public void quit(){
        webDriver.quit();
    }
}