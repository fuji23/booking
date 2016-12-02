package com.booking.lux.pages.results.block;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Oleksandr_Danchenko on 12/1/2016.
 */
public class ResultBlock extends ElementsContainer {

    @FindBy(xpath = ".//div[@class='address']")
    SelenideElement address;

    public String getAddress() {
        return address.getText().trim();
    }
}