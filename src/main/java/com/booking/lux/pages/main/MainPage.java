package com.booking.lux.pages.main;

import com.booking.lux.pages.main.block.FindForm;
import com.booking.lux.pages.main.block.TopBanner;
import org.openqa.selenium.support.FindBy;

/**
 * Created by home-pc on 30.11.2016.
 */
public class MainPage {

    @FindBy(xpath = "//form[*[contains(@class, 'sb-searchbox__row')]]")
    private FindForm findForm;

    @FindBy(id = "top")
    private TopBanner topBanner;


    public FindForm getFindForm() {
        return findForm;
    }

    public TopBanner getTopBanner() {
        return topBanner;
    }
}
