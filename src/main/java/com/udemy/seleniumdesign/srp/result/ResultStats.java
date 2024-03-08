package com.udemy.seleniumdesign.srp.result;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.udemy.seleniumdesign.srp.common.AbstractComponent;

public class ResultStats extends AbstractComponent {

    @FindBy(id = "result-stats")
    private WebElement stat;

    public ResultStats(WebDriver driver) {
        super(driver);
    }

    public String getStat() {
        return this.stat.getText();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.stat.isDisplayed());
    }

}
