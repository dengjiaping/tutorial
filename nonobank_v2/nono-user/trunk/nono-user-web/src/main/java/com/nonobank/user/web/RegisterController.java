/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) RegisterController.java 2014-10-27 16:42
 */

package com.nonobank.user.web;

import com.nonobank.user.facade.dto.core.UserModel;
import com.nonobank.web.annotation.FormModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author fuchun
 * @version $Id: RegisterController.java 298 2014-10-29 03:05:00Z fuchun $
 * @since 2.0
 */
@Controller
@RequestMapping("/user")
public class RegisterController extends UserBaseController {

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(
            @FormModel("user") UserModel userModel,
            ModelMap model) {
        // TODO: 实验性代码，很快就会删除
        return view("/user/register_success.ftl", model);
    }

}
