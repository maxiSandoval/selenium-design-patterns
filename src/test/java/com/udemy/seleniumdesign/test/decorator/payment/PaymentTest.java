package com.udemy.seleniumdesign.test.decorator.payment;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.seleniumdesign.decorator.payment.PaymentPage;
import com.udemy.seleniumdesign.test.BaseTest;

import static com.udemy.seleniumdesign.test.decorator.payment.DecoratorsPayment.*;

public class PaymentTest extends BaseTest {

    private PaymentPage paymentPage;

    @BeforeTest
    public void setPaymentPage() {
        this.paymentPage = new PaymentPage(driver);
    }

    @Test(dataProvider = "getData")
    public void paymentScreenTest(Consumer<PaymentPage> consumer) {
        paymentPage.goTo();
        consumer.accept(paymentPage);

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    @DataProvider
    public Object[] getData() {
        return new Object[] {
                validCC.andThen(buy).andThen(successfulPurchase),
                freeCoupon.andThen(buy).andThen(successfulPurchase),
                discountedCoupon.andThen(validCC).andThen(buy).andThen(successfulPurchase),
                invalidCC.andThen(buy).andThen(failedPurchase),
                invalidCC.andThen(discountedCoupon).andThen(buy).andThen(failedPurchase),
                buy.andThen(failedPurchase)
        };
    }

}
