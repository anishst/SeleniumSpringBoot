package com.demo.seleniumspring.googletests;

import com.demo.seleniumspring.SpringBaseTestNGTest;
import com.demo.seleniumspring.page.google.GooglePage;
import com.demo.seleniumspring.util.ScreenShotUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GoogleSearch2Test extends SpringBaseTestNGTest {

    @Autowired
    private GooglePage googlePage;

    @Lazy // only create the object when needed
    @Autowired
    private ScreenShotUtil screenShotUtil;

    @Test
    public void GoogleTest() throws IOException, InterruptedException {
        this.googlePage.goToGooglePage();
        Assert.assertTrue(this.googlePage.isAt());

        this.googlePage.getSearchComponent().search("Selenium");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
        System.out.println("Number of Results: " + this.googlePage.getSearchResult().getCount());
        // wait 3 seconds
        // Thread.sleep(3000);
        //take screenshot
        //this.screenShotUtil.takeScreenShot("Test.png");
        //this.googlePage.close();
    }
}
