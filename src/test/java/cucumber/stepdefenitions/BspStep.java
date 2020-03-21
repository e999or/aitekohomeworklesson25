package cucumber.stepdefenitions;


import com.codeborne.selenide.Selenide;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BspStep {

    @Дано("пользователь вводит в адресную строку браузера.")
    public void open() {
        Selenide.open("https://idemo.bspb.ru");
    }

    @Дано("нажимает клавишу Войти.")
    public void clickLoginButton() {
        $(By.id("login-button")).click();
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

    @Когда("нажать кнопку: {string}.")
    public void clikOtpCode(String string) {
        $(By.id("login-otp-button")).click();
    }


    @Тогда("откроется новая страница проверить есть ли в title надпись: {string}.")
    public void inspectPreReview(String string) {
        Assert.assertEquals($("title").getAttribute("innerText"), string);
    }

    @Когда("нажать вкладку Обзор.")
    public void clikIdButton() {
        $(By.id("bank-overview")).click();
    }

    @Тогда("откроется вкладка Обзор проверить появилась ли надпись : {string}.")
    public void inspectFild(String string) {
        $(By.id("can-spend")).shouldHave(text("Финансовая свобода"));
    }

    @Когда("нажать на поле Финансовая свобода, которое содержит сумму.")
    public void clikxPathButton() throws InterruptedException {
        Actions actions = new Actions(getWebDriver());
        actions.moveToElement($(By.xpath("//small[@class='my-assets']"))).build().perform();

    }

    @Когда("в появившейся сумме проверить соответствует ли она типу .")
    public void inspectTipe() {
        String str = $(By.xpath("//small[@class='my-assets']")).getAttribute("innerText");
        String sy = String.valueOf(new StringBuffer(str).delete(0,14));
        Matcher matcher = (Pattern.compile("")).matcher(sy);
        Assert.assertTrue(matcher.find());
    }
}
