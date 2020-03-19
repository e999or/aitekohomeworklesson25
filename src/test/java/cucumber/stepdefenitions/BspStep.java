package cucumber.stepdefenitions;


import com.codeborne.selenide.Selenide;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;

public class BspStep {

    @Дано("пользователь вводит в адресную строку браузера: [https:\\/\\/idemo.bspb.ru].")
    public void open() {
        Selenide.open("https://idemo.bspb.ru");
    }

    @Дано("нажимает клавишу [{string}].")
    public void clickLoginButton(String string) {
        $(By.id(string)).click();
    }

    @Тогда("появляется окно 2х факторной идентификации проверить, есть ли на странице :{string}.")
    public void inspectCodePhone(String string) {
        String phone = $(By.xpath("//div[@id='otp-code-text']/b")).getAttribute("innerText");
        Assert.assertTrue(phone.equals(string));
    }

    @Когда("в поле ввода кода ввести: {string}.")
    public void sendKeyskOtpCode(String string) {
        $(By.id("otp-code")).sendKeys(string);
    }

    @Когда("нажать кнопку: [{string}].")
    public void clikOtpCode(String string) {
        $(By.id("login-otp-button")).click();
    }

    @Тогда("откроется новая страница проверить есть ли в title надпись: {string}.")
    public void inspectPreReview(String string) {
        Assert.assertEquals($("title").getAttribute("innerText"), string);
    }

    @Когда("нажать вкладку [{string}].")
    public void clikIdButton(String string) {
        $ (By.id("bank-overview")).click();
    }

    @Тогда("откроется вкладка Обзор проверить появилась ли надпись : {string}.")
    public void inspectFild(String string) {
        Assert.assertEquals($("title").getAttribute("innerText"), string);
    }

    @Когда("нажать на поле Финансовая свобода, которое содержит сумму.")
    public void clikxPathButton() {
        $ (By.xpath("//small[@class='my-assets']")).click();
    }

    @Когда("в появившейся сумме проверить соответствует ли она типу : {string}.")
    public void inspectTipe(String string) {
        String str = $(By.xpath("//small[@class='my-assets']")).getAttribute("innerText");
        String sy = String.valueOf(new StringBuffer(str).delete(0,14));
        Matcher matcher = (Pattern.compile("^[0-9]{1,3} [0-9]{3} [0-9]{3}[.]{1}[0-9]{2} [\u20BD]{1}$")).matcher(sy);
        Assert.assertTrue(matcher.find());
    }
}
