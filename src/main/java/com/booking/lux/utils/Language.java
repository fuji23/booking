package com.booking.lux.utils;

import java.util.Arrays;
import java.util.Locale;

/**
 * Created by Oleksandr_Danchenko on 12/1/2016.
 */

/**
 * Enum keep conjunction of application language with appropriate locale value.
 */
public enum Language {

    EN_US("English (US)", Locale.ENGLISH);

    private String language;
    private Locale locale;

    Language(String lang, Locale loc) {
        language = lang;
        locale = loc;
    }

    public String getLanguage() {
        return language;
    }

    public Locale getLocale() {
        return locale;
    }

    public static Language languageResolver() {
        String locale = System.getProperty("site.language");
        return Arrays.stream(Language.values()).filter(l -> l.getLocale().toLanguageTag().equals(locale)).findFirst().get();
    }
}
