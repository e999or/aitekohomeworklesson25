package com.github.e999or.lesson25;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.*;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    @Дано("пользователь вводи в адресную строку браузера: \"https://idemo.bspb.ru\"")
    LoginPage open() {
        Selenide.open("https://idemo.bspb.ru");
        return this;
    }

    @И("нажимает клавишу \"Войти\"")
    LoginPage clickLoginButton(){
        $(By.id("login-button")).click();
        return this;
    }

    @Когда("появляется окно 2х факторной идентификации провеорить есть ли на странице :\"*1111\"")
    LoginPage inspectCodePhone(){
        String phone = $(By.xpath("//div[@id='otp-code-text']/b")).getAttribute("innerText");
       Assert.assertTrue(phone.equals("*1111"));
       return this;
    }
    @Тогда("в поле ввода кода ввести:\"0000\"")
    LoginPage sendKeyskOtpCode(String keys){
        $(By.id("otp-code")).sendKeys(keys);
        return this;
    }
    @И("нажать кнопку:\"Войти\"")
    LoginPage clikOtpCode(){
        $(By.id("login-otp-button")).click();
        return this;
    }
}
