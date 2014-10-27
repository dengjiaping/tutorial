/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) CustomPerformanceMonitorInterceptor.java 2014-10-27 16:47
 */

package com.nonobank.spring.aop.interceptor;

import com.google.common.base.Stopwatch;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;

import java.util.concurrent.TimeUnit;

/**
 * Simple AOP Alliance {@code MethodInterceptor} for performance monitoring.
 * This interceptor has no effect on the intercepted method call.
 * <p>
 * Uses a {@code Stopwatch} for the actual performance measuring.
 *
 * @author fuchun
 * @version $Id: CustomPerformanceMonitorInterceptor.java 290 2014-10-27 08:48:18Z fuchun $
 * @since 2.0
 */
public class CustomPerformanceMonitorInterceptor
        extends CustomAbstractMonitoringInterceptor {

    private static final long serialVersionUID = -8688901939829545767L;

    /**
     * Create a new CustomPerformanceMonitorInterceptor with a static logger.
     */
    public CustomPerformanceMonitorInterceptor() {
        super();
    }

    /**
     * Create a new CustomPerformanceMonitorInterceptor with a dynamic or static logger,
     * according to the given flag.
     *
     * @param useDynamicLogger whether to use a dynamic logger or a static logger
     * @see #setUseDynamicLogger
     */
    public CustomPerformanceMonitorInterceptor(boolean useDynamicLogger) {
        setUseDynamicLogger(useDynamicLogger);
    }

    @Override
    protected Object invokeUnderTrace(MethodInvocation invocation, Log logger)
            throws Throwable {
        String name = createInvocationTraceName(invocation);
        Stopwatch stopwatch = Stopwatch.createStarted();
        try {
            return invocation.proceed();
        } finally {
            stopwatch.stop();
            long nanos = stopwatch.elapsed(TimeUnit.NANOSECONDS);
            double millis = (double) nanos / 1000000;
            logger.trace(String.format("%s runtime: %s ms, %s ns.", name, millis, nanos));
        }
    }
}
