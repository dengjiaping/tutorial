/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) Views.java 2014-10-23 10:46
 */

package com.nonobank.common.json;

/**
 * 用于提供 jackson2 的{@code JsonView} 注解的属性访问视图标签。
 *
 * @author fuchun
 * @version $Id: Views.java 252 2014-10-23 02:50:27Z fuchun $
 * @since 2.0
 */
public abstract class Views {

    /**
     * 公有访问类型。
     */
    public interface Public {}

    /**
     * 用于扩展公有访问类型。
     */
    public interface ExtendedPublic extends Public {}

    /**
     * 用于内部使用的访问类型。
     */
    public interface Internal extends ExtendedPublic {}
}
