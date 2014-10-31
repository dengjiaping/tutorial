/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserModelValidator.java 2014-10-27 16:40
 */

package com.nonobank.user.facade.validator;

import com.nonobank.user.facade.dto.core.UserModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Objects;
import java.util.regex.Pattern;

import static com.nonobank.user.facade.dto.core.UserModel.*;

/**
 * {@code UserModel} 属性校验器。
 *
 * @author fuchun
 * @version $Id: UserModelValidator.java 306 2014-10-30 02:54:16Z fuchun $
 * @since 2.0
 */
@Component
public class UserModelValidator implements Validator {

    private static final Pattern CHINA_MOBILE = Pattern.compile("1[3,5,8]\\d{9}");

    @Override
    public boolean supports(Class<?> clazz) {
        return UserModel.class.equals(clazz) ||
                UserModel.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, PROP_USER_NAME,
                "user.v.userName.required", "用户名不能为空");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, PROP_MOBILE_NO,
                "user.v.mobileNO.required", "手机号码不能为空");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, PROP_SMS_CAPTCHA,
                "user.v.smsCaptcha.required", "请输入手机验证码");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, PROP_PASSWORD1,
                "user.v.password1.required", "登录密码不能为空");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, PROP_PASSWORD2,
                "user.v.password2.required", "确认密码不能为空");

        UserModel user = (UserModel) target;
        if (user.getUserName() != null) {
            int unl = user.getUserName().length();
            if (unl < 6 || unl > 20) {
                errors.rejectValue(PROP_USER_NAME,
                        "user.v.userName.length", "用户名由6~20个英文、数字或下划线组成");
            }
        }
        if (user.getMobileNO() != null) {
            if (!CHINA_MOBILE.matcher(user.getMobileNO()).matches()) {
                // 目前只支持中国大陆手机号码
                errors.rejectValue(PROP_MOBILE_NO,
                        "user.v.mobileNO.formatter", "手机号码输入错误");
            }
        }
        if (user.getPassword1() != null && user.getPassword2() != null) {
            int pwdLen = user.getPassword1().length();
            if (pwdLen < 8 || pwdLen > 18) {
                errors.rejectValue(PROP_PASSWORD1,
                        "user.v.password.length", "登录密码长度为8~18位英文、数字或特殊字符组成");
            }
            if (!Objects.equals(user.getPassword1(), user.getPassword2())) {
                errors.rejectValue(PROP_PASSWORD2,
                        "user.v.password.confirm", "两次密码输入不一致");
            }
        }
    }
}
