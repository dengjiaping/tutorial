/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserBaseController.java 2014-10-22 13:55
 */

package com.nonobank.user.web;

import com.google.common.base.Joiner;
import com.nonobank.web.servlet.BaseControllerSupport;
import org.springframework.ui.ModelMap;

import javax.annotation.Nonnull;

/**
 * User system base controller.
 *
 * @author fuchun
 * @version $Id: UserBaseController.java 245 2014-10-22 06:28:18Z fuchun $
 * @since 2.0
 */
public class UserBaseController extends BaseControllerSupport {

    @Nonnull
    @Override
    protected String processViewPath(@Nonnull String viewName, @Nonnull ModelMap model) {
        String themeName = webAppConfigure.getTheme().getName();
        return Joiner.on("").join(
                "/", themeName, "/", (viewName.startsWith("/") ?
                        viewName.substring(1) : viewName));
    }
}
