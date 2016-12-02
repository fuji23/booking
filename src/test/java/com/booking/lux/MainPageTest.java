package com.booking.lux;

import com.booking.lux.pages.main.MainPage;
import com.booking.lux.pages.main.block.FindForm;
import com.booking.lux.pages.results.ResultsPage;
import com.booking.lux.utils.DatePicker;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by home-pc on 30.11.2016.
 */
public class MainPageTest {

    @AfterMethod
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

    @Test(description = "Test search functionality")
    @Parameters("destination")
    public void searchTest(/*@Optional(value = "New York")*/ String destination) {
        Reporter.log("Step 1. Open booking.com website.");
        MainPage mainPage = open("http://www.booking.com", MainPage.class);
        mainPage.getTopBanner().selectLocale();

        Reporter.log("Step 2. Search for hotels in New York City for period December 20, 2016 - December 25, 2016.");
        FindForm findForm = mainPage.getFindForm();
        findForm.enterDestination(destination);

        findForm.selectCheckInDate(LocalDate.of(2016, Month.DECEMBER, 20));
        findForm.selectCheckOutDate(LocalDate.of(2016, Month.DECEMBER, 25));

        findForm.selectHotels();

        ResultsPage search = findForm.search();

        Reporter.log("Step 3. Verify that all hotels on the 1 page of results are located in NYC.");
        search.checkResultsAddress(destination);
    }

    @Test(description = "Check that date-picker Check-out will change his value if Check-in date setted up greater.")
    public void dateShift() {
        Reporter.log("Step 1. Open booking.com website.");
        MainPage mainPage = open("http://www.booking.com", MainPage.class);
        mainPage.getTopBanner().selectLocale();

        Reporter.log("Step 2. Set Check-out date as December 25, 2016.");
        FindForm findForm = mainPage.getFindForm();
        findForm.selectCheckOutDate(LocalDate.of(2016, Month.DECEMBER, 25));

        Reporter.log("Step 3. Set Check-in date as December 26, 2016.");
        findForm.selectCheckInDate(LocalDate.of(2016, Month.DECEMBER, 26));

        Reporter.log("Step 4. Check-out's date is shifted up to December 27, 2016.");
        DatePicker.checkSelectedDate(findForm.getCheckOutContainer(), LocalDate.of(2016, Month.DECEMBER, 27));
    }


}
