package com.booking.lux.pages.main.block;

import com.booking.lux.utils.Language;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Oleksandr_Danchenko on 12/1/2016.
 */
public class TopBanner extends ElementsContainer {

    private String localePattern = ".//span[@class='seldescription'][contains(., '%s')]";

    private By loadIndicatorRelative = By.xpath("./following-sibling::i");

    @FindBy(xpath = "//li[contains(@class, 'uc_language')]")
    private SelenideElement languageIcon;

    public void selectLocale(){
        Language language = Language.languageResolver();
        languageIcon.click();
        SelenideElement locElem = languageIcon.$(By.xpath(String.format(localePattern, language.getLanguage())));
        locElem.click();
        locElem.$(loadIndicatorRelative).shouldNotBe(Condition.visible);
    }

}
