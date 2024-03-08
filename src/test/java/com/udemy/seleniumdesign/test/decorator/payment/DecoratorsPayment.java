package com.udemy.seleniumdesign.test.decorator.payment;

import java.util.function.Consumer;

import org.testng.Assert;

import com.udemy.seleniumdesign.decorator.payment.PaymentPage;

/* 
    Purchase should be successful using valid CC
    Purchase should be successful using discounted promocode + valid CC
    Purchase should be successful using FREE promocode
    Purchase should fail using discounted promocode + invalid CC
    Purchase should fail using invalid CC
    Purchase should fail without any payment info 

    Data
    Free Promocode : FREEUDEMY
    Discount Promocode : PARTIALUDEMY
    Valid CC : 4111111111111111
    Valid Year : >2022
    Valid CVV : 123
*/

public class DecoratorsPayment {

      //actions
      public static final Consumer<PaymentPage> freeCoupon = (p) -> p.applyPromocode("FREEUDEMY");
      public static final Consumer<PaymentPage> discountedCoupon = (p) -> p.applyPromocode("PARTIALUDEMY");
      public static final Consumer<PaymentPage> validCC = (p) -> p.enterCC("4111111111111111", "2023", "123");
      public static final Consumer<PaymentPage> invalidCC = (p) -> p.enterCC("4111111111111112", "2023", "123");
      public static final Consumer<PaymentPage> buy = (p) -> p.buyProduct();

      //validations
      public static final Consumer<PaymentPage> successfulPurchase = (p) -> Assert.assertEquals(p.getStatus(), "PASS");
      public static final Consumer<PaymentPage> failedPurchase = (p) -> Assert.assertEquals(p.getStatus(), "FAIL");
}
