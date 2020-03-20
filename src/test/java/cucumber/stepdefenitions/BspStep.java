package cucumber.stepdefenitions;


import com.codeborne.selenide.Selenide;

import io.cucumber.java.ru.*;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;

public class BspStep {

    @Допустим("тра ля ля")
    public void тра_ля_ля() {
        System.out.println("123");
        throw new io.cucumber.java.PendingException();

    }
}
