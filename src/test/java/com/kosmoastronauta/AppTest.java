package com.kosmoastronauta;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppTest
{
    public static final String WEB = "http://localhost:4200/";
    public WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupTest() {
         driver= new ChromeDriver();
    }

    @AfterEach
    public void teardown() {
       // driver.close();
    }

    @Test
    public void checkingTitleOfWebsite() {
        driver.get(WEB);
        Assertions.assertEquals("AngularLA",driver.getTitle());
    }

    @Test
    public void addingMemberWithoutAnyData() throws InterruptedException
    {
        String message = "";
        driver.get(WEB);
        driver.findElement(By.id("addMemberNav")).click();
        driver.findElement(By.id("submitMember")).click();
        Thread.sleep(1000);

        try
        {
            Alert alert;
            alert = driver.switchTo().alert();
            message = alert.getText();
        }catch(UnhandledAlertException e)
        {
            System.out.println(message);
            Assertions.assertEquals(message, "Error while creating new member");
        }
    }
}
