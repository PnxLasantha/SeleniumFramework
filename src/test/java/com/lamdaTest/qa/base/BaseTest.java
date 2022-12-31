package com.lamdaTest.qa.base;

import com.lamdaTest.qa.factory.BrowserFactory;
import com.lamdaTest.qa.pages.HomePage;
import com.lamdaTest.qa.pages.SimpleFormDemoPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {


    protected HomePage homePage;
    protected SimpleFormDemoPage simpleFormDemoPage;
    public BrowserFactory bf;
    public static WebDriver driver;
    @BeforeTest
    public void browserSetup(){
        bf = new BrowserFactory();

    }
    @BeforeMethod
    public void setUp() {

        driver= bf.initialization();
        homePage = new HomePage();

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }

    public String testData(String key){
       return bf.testData(key);
    }

}
