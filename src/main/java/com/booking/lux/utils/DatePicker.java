package com.booking.lux.utils;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.apache.commons.lang3.StringUtils.swapCase;

/**
 * Created by home-pc on 30.11.2016.
 */
public class DatePicker {

    private static final String datePattern = ".//div[@data-id][table[contains(., '%s " +
            "%s')]]//span[@class='c2-day-inner'][contains(., '%d')]";

    /**
     * Select date for particular date-picker
     * @param fromContainer date-picker input container
     * @param date given date
     */
    public static void selectDate(SelenideElement fromContainer, LocalDate date) {
        String month = capitalize(swapCase(date.getMonth().toString()));
        fromContainer.click();
        fromContainer.$(By.xpath(String.format(datePattern, month, date.getYear(), date.getDayOfMonth())))
                .click();
    }

    /**
     * Check if particular date-picker contains expected date
     * @param fromContainer date-picker input container
     * @param expectedDate expected date
     */
    public static void checkSelectedDate(SelenideElement fromContainer, LocalDate expectedDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy", Language.languageResolver().getLocale());
        String date = LocalDate.of(expectedDate.getYear(), expectedDate.getMonth(), expectedDate.getDayOfMonth())
                .format(formatter);

        String actualDate = fromContainer.getText();
        Assert.assertTrue(actualDate.contains(date),
                "Actual date is ".concat(actualDate) + " but expected is ".concat(expectedDate.format(formatter)));
    }
}
