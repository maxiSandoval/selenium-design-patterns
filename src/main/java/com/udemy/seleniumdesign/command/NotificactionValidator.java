package com.udemy.seleniumdesign.command;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import com.google.common.util.concurrent.Uninterruptibles;

public class NotificactionValidator extends ElementValidator{

    private final WebElement button;
    private final WebElement notificaction;
    
    /* 
     * We are not finding the element here. 
     * We assume that somebody will give us the web element.
     */

    public NotificactionValidator(final WebElement button, final WebElement notificaction) {
        this.button = button;
        this.notificaction = notificaction;
    }

    @Override
    public boolean validate() {
        this.button.click();
        boolean appearanceState = this.notificaction.isDisplayed();
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
        boolean disappearanceState = this.notificaction.isDisplayed();
        return appearanceState && (!disappearanceState);
    }
    

}
