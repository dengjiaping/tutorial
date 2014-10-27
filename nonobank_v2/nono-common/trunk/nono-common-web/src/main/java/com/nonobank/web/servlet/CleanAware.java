/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) CleanAware.java 2014-10-27 16:47
 */

package com.nonobank.web.servlet;

/**
 * 实现此接口的{@code Controller} 在请求执行后进行资源清理操作。
 *
 * @author fuchun
 * @version $Id: CleanAware.java 290 2014-10-27 08:48:18Z fuchun $
 * @since 2.0
 */
public interface CleanAware {

    /**
     * 清理回收资源。
     */
    public void cleanUp();
}
