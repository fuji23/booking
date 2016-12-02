package com.booking.lux.pages.main.block;

import com.booking.lux.pages.results.ResultsPage;
import com.booking.lux.utils.DatePicker;
import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by home-pc on 30.11.2016.
 */
public class FindForm extends ElementsContainer {

    @FindBy(xpath = ".//div[div[@class='sb-searchbox__label']][contains(.,'Check-in')]")
    SelenideElement checkInContainer;

    @FindBy(xpath = ".//div[div[@class='sb-searchbox__label']][contains(.,'Check-out')]")
    SelenideElement checkOutContainer;

    @FindBy(xpath = ".//input[contains(@class, 'sb-destination')]")
    SelenideElement inputDestination;

    @FindBy(xpath = ".//button[contains(@class, 'sb-searchbox__button')]")
    SelenideElement searchButton;

    @FindBy(xpath = ".//input[contains(@class, 'input-hotels')]")
    SelenideElement checkBoxHotels;

    public void enterDestination(String dest) {
        inputDestination.sendKeys(dest);
    }

    public void selectCheckInDate(LocalDate date) {
        DatePicker.selectDate(checkInContainer, date);
    }

    public void selectCheckOutDate(LocalDate date) {
        DatePicker.selectDate(checkOutContainer, date);
    }

    public ResultsPage search() {
        searchButton.click();
        return page(ResultsPage.class);
    }

    public void selectHotels() {
        checkBoxHotels.click();
    }

    public SelenideElement getCheckOutContainer() {
        return checkOutContainer;
    }
}
