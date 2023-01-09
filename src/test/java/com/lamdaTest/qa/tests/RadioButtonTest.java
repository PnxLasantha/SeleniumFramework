package com.lamdaTest.qa.tests;

import com.lamdaTest.qa.base.BaseTest;
import com.lamdaTest.qa.pages.RadioButtonDemoPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RadioButtonTest extends BaseTest {

RadioButtonDemoPage radioButtonDemoPage;
    @DataProvider(name = "gender-data-provider")
    public Object[][] singleRadioButton(){
        return new Object[][] {{"Male"}, {"Female"}};
    }
@Test(dataProvider = "gender-data-provider")
    public void verifySingleRadioButton(String gender){
    test = extentReports.createTest("Verify single radio button ");
        radioButtonDemoPage = homePage.clickOnDemoLink("Radio Buttons Demo");
        radioButtonDemoPage.clickOnRadioButtonDemo(gender);
        radioButtonDemoPage.clickOngetCheckedValueButton();
        Assert.assertTrue(radioButtonDemoPage.checkSingleRadioButtonText(gender));

    }
    @DataProvider(name = "groupradiobutton-data-provider")
    public Object[][] groupRadioButton(){
        return new Object[][] {{"Male","0 - 5"}, {"Female","5 - 15"}, {"Other","15 - 50"}};
    }
    @Test(dataProvider = "groupradiobutton-data-provider")
    public void verfiyGroupRadioButton(String gender , String ageGroup){
        test = extentReports.createTest("Verify group radio button ");
        radioButtonDemoPage = homePage.clickOnDemoLink("Radio Buttons Demo");
        radioButtonDemoPage.clickOnGenderGroupRadioButton(gender);
        radioButtonDemoPage.clickOnAgeGroupRadioButton(ageGroup);
        radioButtonDemoPage.clickOnGetValuesButton();
        Assert.assertEquals(radioButtonDemoPage.getGenderDisplayText(),gender);
        Assert.assertEquals(radioButtonDemoPage.getAgeGroupDisplayText(),ageGroup);

    }
}
