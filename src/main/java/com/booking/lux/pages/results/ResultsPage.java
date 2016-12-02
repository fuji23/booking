package com.booking.lux.pages.results;

import com.booking.lux.pages.results.block.ResultBlock;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Oleksandr_Danchenko on 12/1/2016.
 */
public class ResultsPage {

    @FindBy(xpath = "//div[@id='hotellist_inner']//div[contains(@class, 'sr_item_new')]")
    private List<ResultBlock> resultsBlocks;

    public void checkResultsAddress(String requestedAddress){
        Assert.assertTrue(resultsBlocks.stream().allMatch(a -> a.getAddress().contains(requestedAddress)),
                "All hotels on the search page of results are located in ".concat(requestedAddress));
    }

}
