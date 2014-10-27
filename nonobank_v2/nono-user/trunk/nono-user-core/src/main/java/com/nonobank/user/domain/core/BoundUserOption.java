/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) BoundUserOption.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.core;

import java.util.List;

/**
 * 绑定用户的{@code UserOption} 操作接口。
 *
 * @author fuchun
 * @version $Id: BoundUserOption.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public interface BoundUserOption {

    /**
     * 返回绑定的用户Id。
     */
    Long getUserId();

    /**
     * 返回用户的所有配置信息。
     */
    List<UserOption> options();

    UserOption getOption(String key);
}
