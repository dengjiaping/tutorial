/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) AbstractUserRemotingTest.java 2014-10-22 12:31
 */

package com.nonobank.user.facade;

import com.caucho.hessian.client.HessianProxyFactory;
import org.junit.BeforeClass;
import org.junit.Ignore;

/**
 * 此测试需要启动 nono-user-web 应用后才能进行，故单独进行测试。
 *
 * @author fuchun
 * @version $Id: AbstractUserRemotingTest.java 244 2014-10-22 05:45:01Z fuchun $
 * @since 2.0
 */
@Ignore
public class AbstractUserRemotingTest {

    protected static final HessianProxyFactory hessianFactory = new HessianProxyFactory();

    protected static String host = "127.0.0.1";
    protected static int port = 8089;
    protected static String contextPath = "/";

    @BeforeClass
    public static void initialize() {
        // 很重要！！！ 接口中有重载的方法时，必须设置
        hessianFactory.setOverloadEnabled(true);
    }

    protected static String createUrl(String path) {
        String ctxPath = contextPath;
        if ("/".equals(contextPath)) {
            ctxPath = "";
        }
        String relPath = path;
        if (path.startsWith("/")) {
            relPath = path.substring(1);
        }
        return String.format("http://%s:%s/%s%s", host, port, ctxPath, relPath);
    }

    protected static <T> T remotingInterface(Class<T> clazz, String path)
            throws Exception {
        return clazz.cast(hessianFactory.create(clazz, createUrl(path)));
    }
}