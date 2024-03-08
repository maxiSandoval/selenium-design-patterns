package com.udemy.seleniumdesign.test.strategy;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.beust.jcommander.internal.Maps;
import com.udemy.seleniumdesign.strategy.PaymentOptionFactory;
import com.udemy.seleniumdesign.strategy.PaymentScreen;
import com.udemy.seleniumdesign.test.BaseTest;

public class PaymentScreenTest extends BaseTest {

    private PaymentScreen paymentScreen;

    @BeforeTest
    public void setPaymentScreen() {
        this.paymentScreen = new PaymentScreen(driver);
    }

    @Test(dataProvider = "getData")
    public void paymentTest(String option, Map<String, String> paymentDetails) {
        this.paymentScreen.goTo();
        this.paymentScreen.getUserInformation().enterDetails("maxi", "sandoval", "selenium@sleenium.com");
        this.paymentScreen.setPaymentOption(PaymentOptionFactory.get(option));
        this.paymentScreen.pay(paymentDetails);
        String orderNumber = this.paymentScreen.getOrder().placeOrder();
        System.out.println("OrderNumber : " + orderNumber);
    }

    @DataProvider
    public Object[][] getData() {

        Map<String, String> cc = Maps.newHashMap();
        cc.put("cc", "333333333");
        cc.put("year", "2024");
        cc.put("cvv", "333");

        Map<String, String> nb = Maps.newHashMap();
        nb.put("bank", "WELLS FARGO");
        nb.put("account", "myaccount123");
        nb.put("pin", "333");

        return new Object[][] {
                {"CC", cc},
                {"NB", nb}
        };
    }
}
