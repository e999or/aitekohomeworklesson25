package com.github.e999or.lesson25;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class SimpleTest {
    private static final Logger LOG = LoggerFactory.getLogger(SimpleTest.class);

    @BeforeMethod
    public void beforeTestMethod() {
        LOG.info("Before test method");
    }

    @AfterMethod
    public void afterTestMethod() {

        LOG.info("After test method");
    }

    @Test
    public void shouldAnswerWithTrue() {
        LoginPage loginPage = new LoginPage();
        ReviewButton reviewButton = new ReviewButton();
        loginPage.open()
                .clickLoginButton()
                .inspectCodePhone()
                .sendKeyskOtpCode("0000")
                .clikOtpCode();

        reviewButton.inspectPreReview()
                .clikIdButton()
                .inspectFild()
                .clikxPathButton()
                .inspectTipe();
    }
}