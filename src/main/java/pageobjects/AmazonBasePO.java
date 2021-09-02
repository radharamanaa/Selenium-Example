package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonBasePO {
    private WebDriver driver;
    private By sideBarOpen = By.cssSelector("#nav-main div.nav-left");
    private By sideBar =By.id("hmenu-container");

    public AmazonBasePO(WebDriver driver) {
        this.driver = driver;
    }

    public void showPopUp(){
        driver.findElement(sideBarOpen).click();
    }
    public boolean isSideBarOpen(){
        final WebElement sideBar = driver.findElement(this.sideBar);
        return sideBar.isDisplayed();
    }
}
