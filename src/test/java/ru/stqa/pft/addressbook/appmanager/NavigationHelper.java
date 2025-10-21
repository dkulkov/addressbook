package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends BaseHelper {


    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void groupPage() {
        click(By.linkText("groups"));

    }
}
