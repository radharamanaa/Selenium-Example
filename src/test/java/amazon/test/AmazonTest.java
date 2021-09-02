package amazon.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageobjects.AmazonBasePO;

import java.util.concurrent.TimeUnit;

public class AmazonTest {
    public static WebDriver driver;

    @Test
    public void tc001_testSignInPopUp(){
        driver.get("http://amazon.in");
        AmazonBasePO basePO =  new AmazonBasePO(driver);
        basePO.showPopUp();
        assert basePO.isSideBarOpen();
    }
    @BeforeSuite
    public void beforeSuite(){
        //we need to have properties in application.properties as required in below class
        Class<? extends WebDriver> driverClass = ChromeDriver.class;
        WebDriverManager.getInstance(driverClass).setup();
        try {
            driver = driverClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            System.exit(-1);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterSuite
    public void suiteTeardown(){
        driver.close();
        driver.quit();
    }


}
