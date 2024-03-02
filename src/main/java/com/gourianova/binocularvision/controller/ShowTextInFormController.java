package com.gourianova.binocularvision.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller


public class ShowTextInFormController {

    @RequestMapping(value = "/showTextInForm", method = RequestMethod.POST)
    public String index() {
        return "/views/jsp/user_register.jsp";
    }
}