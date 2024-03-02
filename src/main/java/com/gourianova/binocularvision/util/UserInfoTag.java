package com.gourianova.binocularvision.util;


import com.gourianova.binocularvision.model.User;
import lombok.Setter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;


@Setter
public class UserInfoTag extends TagSupport {
    private User user;

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().write( " " + user.getFirstname() + ", " + user.getBalance() + " BYR");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}

