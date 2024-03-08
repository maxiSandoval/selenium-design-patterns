package com.udemy.seleniumdesign.srp.result;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.udemy.seleniumdesign.srp.common.AbstractComponent;

public class NavigationBar extends AbstractComponent{

    @FindBy(id = "hdtb")
    private WebElement bar;

    @FindBy(linkText = "Images")
    private WebElement images;

    @FindBy(xpath = "//span[contains(text(), 'Vídeos')]")
    private WebElement videos;

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public void goToImages(){
        this.images.click();
    }

    public void goToVideos(){
        this.wait.until((d) -> this.videos.isDisplayed());
        this.videos.click();
    }

    @Override
    public boolean isDisplayed() {
         return this.wait.until((d) -> this.bar.isDisplayed());
    }
    
}
