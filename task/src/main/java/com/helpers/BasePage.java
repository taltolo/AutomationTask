package com.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {
    private WebDriver driver;
   

    public BasePage(WebDriver driver){
        driver=driver;
    }

    public void navigateToWebPage(String url){
        driver.get(url);
    }

    public Boolean insertText(WebElement element, String textToinsert) {
        element.sendKeys(textToinsert);
        String textAfter = element.getText();
        if(textAfter.isEmpty()){
            textAfter = element.getAttribute("value");
        }
        return textToinsert.equals(textAfter);    }
}
