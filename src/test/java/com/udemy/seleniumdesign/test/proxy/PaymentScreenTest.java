package com.udemy.seleniumdesign.test.proxy;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import com.udemy.seleniumdesign.proxy.PaymentOptionFactory;
import com.udemy.seleniumdesign.proxy.PaymentScreen;
import com.udemy.seleniumdesign.test.BaseTest;

public class PaymentScreenTest extends BaseTest {

    private PaymentScreen paymentScreen;

    @BeforeTest
    public void setPaymentScreen() {
        System.setProperty("env", "PROD");
        this.paymentScreen = new PaymentScreen(driver);
    }

    @Test(dataProvider = "getData")
    public void paymentTest(String option, Map<String, String> paymentDetails) {
        this.paymentScreen.goTo();
        this.paymentScreen.getUserInformation().enterDetails("maxi", "sandoval", "selenium@sleenium.com");
        this.paymentScreen.setPaymentOption(PaymentOptionFactory.get(option));
        this.paymentScreen.pay(paymentDetails);
        String orderNumber = this.paymentScreen.getOrderComponent().placeOrder();
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
