package com.udemy.seleniumdesign.command;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class DismissalAlertValidator extends ElementValidator{

    private final WebElement dismissalAlert;

    public DismissalAlertValidator(final WebElement element){
        this.dismissalAlert = element;
    }

    @Override
    public boolean validate() {
        boolean result1 = this.dismissalAlert.isDisplayed();
        this.dismissalAlert.findElement(By.cssSelector("button.close")).click();
        
        // Buscar forma de mejorar el try catch
        boolean result2;
        try {
            this.dismissalAlert.isDisplayed();
            result2 = true;
        } catch (NoSuchElementException e) {
            result2 = false;
        }

        return result1 && (!result2);
    }
    

}
