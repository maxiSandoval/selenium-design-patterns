package com.udemy.seleniumdesign.test.decorator.dashboard;

import java.util.List;
import java.util.function.Consumer;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.udemy.seleniumdesign.decorator.dashboard.DashboardPage;

public class DecoratorsDashboard {

        private static void shouldDisplay(List<WebElement> elements) {
                elements.forEach(element -> Assert.assertTrue(element.isDisplayed()));
        }

        private static void shouldNotDisplay(List<WebElement> elements) {
                elements.forEach(element -> Assert.assertFalse(element.isDisplayed()));
        }

        // Ingredients
        private static final Consumer<DashboardPage> adminComponentPresent = (dp) -> shouldDisplay(
                        dp.getAdminComponents());
        private static final Consumer<DashboardPage> adminComponentNotPresent = (dp) -> shouldNotDisplay(
                        dp.getAdminComponents());

        private static final Consumer<DashboardPage> superComponentPresent = (dp) -> shouldDisplay(
                        dp.getSuperUserComponents());
        private static final Consumer<DashboardPage> superComponentNotPresent = (dp) -> shouldNotDisplay(
                        dp.getSuperUserComponents());

        private static final Consumer<DashboardPage> guestComponentPresent = (dp) -> shouldDisplay(
                        dp.getGuestComponents());

        // role selection
        private static final Consumer<DashboardPage> adminSelection = (dp) -> dp.selectRole("admin");
        private static final Consumer<DashboardPage> superSelection = (dp) -> dp.selectRole("superuser");
        private static final Consumer<DashboardPage> guestSelection = (dp) -> dp.selectRole("guest");

        // user role pages
        public static final Consumer<DashboardPage> guestPage = guestSelection.andThen(guestComponentPresent)
                        .andThen(adminComponentNotPresent).andThen(superComponentNotPresent);

        public static final Consumer<DashboardPage> superPage = superSelection.andThen(superComponentPresent)
                        .andThen(adminComponentNotPresent).andThen(guestComponentPresent);

        public static final Consumer<DashboardPage> adminPage = adminSelection.andThen(adminComponentPresent)
                        .andThen(superComponentPresent).andThen(guestComponentPresent);

}
