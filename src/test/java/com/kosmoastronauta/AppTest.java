package com.kosmoastronauta;

import com.kosmoastronauta.page.AddMemberPage;
import com.kosmoastronauta.page.SideMenu;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest
{
    public static final String WEB = "http://localhost:4200/";
    private static WebDriver driver;
    private static SideMenu sideMenu;
    private static AddMemberPage addMemberPage;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        sideMenu = new SideMenu(driver);
        addMemberPage = new AddMemberPage(driver);
    }

    @BeforeEach
    public void setupTest() {

    }

    @AfterEach
    public void teardown() {
       // driver.close();
    }

    @AfterAll
    public static void close()
    {
        driver.close();
        driver.quit();
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
        Thread.sleep(1000);
        sideMenu.clickAddMemberButton();

        addMemberPage.clickAddMemberButton();
        Thread.sleep(1000);

        try
        {
            Alert alert;
            alert = driver.switchTo().alert();
            message = alert.getText();
        }catch(UnhandledAlertException e)
        {
            Assertions.assertEquals(message, "Error while creating new member");
        }
    }
}
