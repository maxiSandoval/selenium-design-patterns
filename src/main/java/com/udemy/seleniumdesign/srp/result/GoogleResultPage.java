package com.udemy.seleniumdesign.srp.result;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.udemy.seleniumdesign.srp.common.SearchSuggestion;
import com.udemy.seleniumdesign.srp.common.SearchWidget;

public class GoogleResultPage {

    private SearchWidget searchWidget;
    private SearchSuggestion searchSuggestion;
    private NavigationBar navigationBar;
    private ResultStats resultStats;

    public GoogleResultPage(final WebDriver driver){
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
        //or
        this.searchSuggestion = new SearchSuggestion(driver);
        this.navigationBar = new NavigationBar(driver);
        this.resultStats = new ResultStats(driver);
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }

    public ResultStats getResultStats() {
        return resultStats;
    }

    
}
