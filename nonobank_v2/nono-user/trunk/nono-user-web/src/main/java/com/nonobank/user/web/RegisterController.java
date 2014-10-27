/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) RegisterController.java 2014-10-27 16:42
 */

package com.nonobank.user.web;

import com.nonobank.user.facade.dto.core.UserModel;
import com.nonobank.user.facade.validator.UserModelValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author fuchun
 * @version $Id: RegisterController.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
@Controller
@RequestMapping("/user")
public class RegisterController extends UserBaseController {

    @Resource
    private UserModelValidator userModelValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        if (binder.getTarget() instanceof UserModel) {
            binder.setValidator(userModelValidator);
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(
            @Valid UserModel user, Errors errors,
            @RequestBody MultiValueMap<String, String> values,
            ModelMap model) {

        if (errors.hasErrors()) {
            return view("/user/register", model);
        }
        user.setExtended(values);
        return view("/user/register_success", model);
    }

}
