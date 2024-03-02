package com.gourianova.binocularvision.controller;

import com.gourianova.binocularvision.exception.UserNotFoundException;
import com.gourianova.binocularvision.model.User;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
@RestController
@RequestMapping("/SwitchLanguage")
public class SwitchLanguageController {
//   private final MessageSource messageSource;
    private  LocaleResolver localeResolver;
   String language;
    @RequestMapping(value = "/local", method = RequestMethod.GET)
    public ModelAndView ChangeLocaleAction() {
        return new ModelAndView("/SwitchLanguage", "localization", new LocaleResolver() {
            @Override
            public Locale resolveLocale(HttpServletRequest request) {
                final String lang = request.getHeader("local");
                return Locale.forLanguageTag(lang);
            }

            @Override
            public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

            }
        });
    }

    //@RequestMapping(value = "/views/jsp/SwitchLanguage", method = RequestMethod.POST)
/*
    public String SwitchLanguage(@ModelAttribute("SpringWeb") LocaleResolver localeResolver,
                               ModelMap model) throws Exception {

        model.addAttribute("local", this.language);
        return "ok";
    }

    public SwitchLanguageController(LocaleResolver localeResolver) {
        this.localeResolver = localeResolver;
    }

    @GetMapping("/SwitchLanguage")
    public Locale Language(@RequestParam("locale") HttpServletRequest request) {

        return  localeResolver.resolveLocale(request); //"/views/jsp/user_register.jsp";
    }
 /*   @RequestMapping(value = "/SwitchLanguage", method = RequestMethod.POST)
    public String index2() {
        return "/views/jsp/user_register.jsp";
    }
*/

}

