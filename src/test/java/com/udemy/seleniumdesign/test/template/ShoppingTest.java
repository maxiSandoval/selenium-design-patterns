package com.udemy.seleniumdesign.test.template;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.udemy.seleniumdesign.template.AmazonShopping;
import com.udemy.seleniumdesign.template.EBayShopping;
import com.udemy.seleniumdesign.template.ShoppingTemplate;
import com.udemy.seleniumdesign.test.BaseTest;

public class ShoppingTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void shoppingTest(ShoppingTemplate shoppingTemplate) {
        shoppingTemplate.shop();
    }

    @DataProvider
    public Object[] getData() {
        return new Object[] {
                new AmazonShopping(driver, "samsung 4k"),
                new EBayShopping(driver, "samsung 4k")
        };
    }

}
