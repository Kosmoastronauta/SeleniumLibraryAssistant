package com.kosmoastronauta;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest
{
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
        driver.close();
    }

    @Test
    public void test() {
        driver.get("http://localhost:4200/");
        Assertions.assertEquals("AngularLA",driver.getTitle());
    }
}
