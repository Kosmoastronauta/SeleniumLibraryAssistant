package com.kosmoastronauta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideMenu
{
    public SideMenu(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "booksNav")
    private WebElement booksButton;

    @FindBy(id = "membersNav")
    private WebElement membersButton;

    @FindBy(id = "addMemberNav")
    private WebElement addMemberButton;

    @FindBy(id = "addBookNav")
    private WebElement addBookButton;

    public void clickBooksButton() {
        booksButton.click();
    }

    public void setBooksButton(WebElement booksButton) {
        this.booksButton = booksButton;
    }

    public void clickMembers() {
        membersButton.click();
    }

    public void setMembersButton(WebElement membersButton) {
        this.membersButton = membersButton;
    }

    public void clickAddMemberButton() {
        addMemberButton.click();
    }

    public void setAddMemberButton(WebElement addMemberButton) {
        this.addMemberButton = addMemberButton;
    }

    public void clickAddBookButton() {
        addBookButton.click();
    }

    public void setAddBookButton(WebElement addBookButton) {
        this.addBookButton = addBookButton;
    }
}
