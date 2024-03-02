package com.gourianova.binocularvision.config;

//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class UserLocaleResolver
implements LocaleResolver {

    // @Override
    //   public Locale resolveLocale(Locale english) {
    //     return resolveLocale(Locale.ENGLISH);
    //}

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        final String lang = request.getHeader("language");
        return Locale.forLanguageTag(lang);
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {
    }
}

/*  @Override
    public Locale resolveLocale(HttpServletRequest request) {
        final String lang = request.getHeader("Language");
        return Locale.forLanguageTag(lang);
    }




    }*/
//}
