/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) RegisterController.java 2014-10-27 16:42
 */

package com.nonobank.user.web;

import com.nonobank.user.facade.dto.core.SchoolUserModel;
import com.nonobank.user.facade.dto.core.UserModel;
import com.nonobank.user.facade.validator.UserModelValidator;
import com.nonobank.web.annotation.FormModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @author fuchun
 * @version $Id: RegisterController.java 306 2014-10-30 02:54:16Z fuchun $
 * @since 2.0
 */
@Controller
@RequestMapping("/user")
public class RegisterController extends UserBaseController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        if (binder.getTarget() instanceof UserModel) {
            binder.setValidator(new UserModelValidator());
        }
    }

    @RequestMapping(value = "/register/student", method = RequestMethod.POST)
    public ModelAndView register(
            ServletWebRequest webRequest,
            @FormModel("user") @Valid SchoolUserModel userModel,
            BindingResult result,
            ModelMap model) {

        // TODO: 实验性代码，很快就会删除
        return view("/user/register_success.ftl", model);
    }

}
