package com.kosmoastronauta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddMemberPage
{
    public AddMemberPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "nameField")
    private WebElement nameField;

    @FindBy(id = "lastNameField")
    private WebElement lastNameField;

    @FindBy(id = "emailField")
    private WebElement emailField;

    @FindBy(id = "submitMember")
    private WebElement submitMemberButton;

    public void enterName(String name)
    {
        nameField.sendKeys(name);
    }

    public void enterLastName(String lastName)
    {
        lastNameField.sendKeys(lastName);
    }

    public void enterEmail(String email)
    {
        emailField.sendKeys(email);
    }

    public void clickAddMemberButton()
    {
        this.submitMemberButton.click();
    }
}
