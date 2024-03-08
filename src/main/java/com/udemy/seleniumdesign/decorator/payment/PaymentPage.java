package com.udemy.seleniumdesign.decorator.payment;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {
    
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "cc")
    private WebElement cc;

    @FindBy(id = "year")
    private WebElement year;

    @FindBy(id = "cvv")
    private WebElement cvv;

    @FindBy(id = "coupon")
    private WebElement coupon;

    @FindBy(id = "buy")
    private WebElement buy;

    @FindBy(id = "couponbtn")
    private WebElement couponBtn;

    @FindBy(id = "status")
    private WebElement status;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-payment-screen.html");
    }

    public void enterCC(String cc, String year, String cvv){
        this.cc.sendKeys(cc);
        this.year.sendKeys(year);
        this.cvv.sendKeys(cvv);
    }

    public void applyPromocode(String coupon){
        this.coupon.sendKeys(coupon);
        this.couponBtn.click();
    }

    public void buyProduct(){
        this.buy.click();
    }

    public String getStatus(){
        this.wait.until((d) -> this.status.isDisplayed());
        return this.status.getText().trim();
    }
}