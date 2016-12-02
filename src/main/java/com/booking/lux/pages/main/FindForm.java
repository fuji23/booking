package com.booking.lux.pages.main;

import com.booking.lux.utils.DatePicker;
import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by home-pc on 30.11.2016.
 */
public class FindForm extends ElementsContainer {

    @FindBy(xpath = "//div[div[@class='sb-searchbox__label']][contains(.,'Check-in')]")
    private SelenideElement checkInContainer;

    @FindBy(xpath = "//div[div[@class='sb-searchbox__label']][contains(.,'Check-out')]")
    private SelenideElement checkOutContainer;

    public void selectCheckInDate(LocalDate date) {
        DatePicker.selectDate(checkInContainer, date);
    }

    public void selectCheckOutDate(LocalDate date) {
        DatePicker.selectDate(checkOutContainer, date);
    }

}
