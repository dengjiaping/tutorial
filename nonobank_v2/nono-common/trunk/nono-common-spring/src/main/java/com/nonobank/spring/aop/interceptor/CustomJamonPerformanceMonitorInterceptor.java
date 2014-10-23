/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) CustomJamonPerformanceMonitorInterceptor.java 2014-09-24 16:34
 */

package com.nonobank.spring.aop.interceptor;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;

/**
 * Performance monitor interceptor that uses <b>JAMon</b> library
 * to perform the performance measurement on the intercepted method
 * and output the stats.
 *
 * @author fuchun
 * @version $Id: CustomJamonPerformanceMonitorInterceptor.java 30 2014-09-26 07:31:15Z fuchun $
 * @since 2.0
 */
public class CustomJamonPerformanceMonitorInterceptor
        extends CustomAbstractMonitoringInterceptor {

    private static final long serialVersionUID = -1436622464690135888L;
    private boolean trackAllInvocations = false;

    /**
     * Create a new CustomJamonPerformanceMonitorInterceptor with a static logger.
     */
    public CustomJamonPerformanceMonitorInterceptor() {
    }

    /**
     * Create a new CustomJamonPerformanceMonitorInterceptor with a dynamic or static logger,
     * according to the given flag.
     * @param useDynamicLogger whether to use a dynamic logger or a static logger
     * @see #setUseDynamicLogger
     */
    public CustomJamonPerformanceMonitorInterceptor(boolean useDynamicLogger) {
        setUseDynamicLogger(useDynamicLogger);
    }

    /**
     * Create a new CustomJamonPerformanceMonitorInterceptor with a dynamic or static logger,
     * according to the given flag.
     * @param useDynamicLogger whether to use a dynamic logger or a static logger
     * @param trackAllInvocations whether to track all invocations that go through
     * this interceptor, or just invocations with trace logging enabled
     * @see #setUseDynamicLogger
     */
    public CustomJamonPerformanceMonitorInterceptor(
            boolean useDynamicLogger, boolean trackAllInvocations) {
        setUseDynamicLogger(useDynamicLogger);
        setTrackAllInvocations(trackAllInvocations);
    }


    /**
     * Set whether to track all invocations that go through this interceptor,
     * or just invocations with trace logging enabled.
     * <p />Default is "false": Only invocations with trace logging enabled will
     * be monitored. Specify "true" to let JAMon track all invocations,
     * gathering statistics even when trace logging is disabled.
     */
    public void setTrackAllInvocations(boolean trackAllInvocations) {
        this.trackAllInvocations = trackAllInvocations;
    }


    /**
     * Always applies the interceptor if the "trackAllInvocations" flag has been set;
     * else just kicks in if the log is enabled.
     * @see #setTrackAllInvocations
     * @see #isLogEnabled(org.apache.commons.logging.Log)
     */
    @Override
    protected boolean isInterceptorEnabled(MethodInvocation invocation, Log logger) {
        return (this.trackAllInvocations || isLogEnabled(logger));
    }

    @Override
    protected Object invokeUnderTrace(MethodInvocation invocation, Log logger)
            throws Throwable {
        if (!isEnabled()) {
            return invocation.proceed();
        }
        String name = createInvocationTraceName(invocation);
        Monitor monitor = MonitorFactory.start(name);
        try {
            return invocation.proceed();
        } finally {
            monitor.stop();
            if (!this.trackAllInvocations || isLogEnabled(logger)) {
                if (logger.isTraceEnabled()) {
                    logger.trace(String.format("%s: (%s)",
                            monitor.getMonKey(), monitorString(monitor)));
                }
            }
        }
    }

    private String monitorString(final Monitor monitor) {
        final ImmutableMap.Builder<String, Object> builder = ImmutableMap.builder();
        builder.put("LastValue", monitor.getLastValue());
        builder.put("Hits", monitor.getHits());
        builder.put("Avg", BigDecimal.valueOf(monitor.getAvg()).setScale(2, HALF_UP));
        builder.put("Total", BigDecimal.valueOf(monitor.getTotal()).setScale(2, HALF_UP));
        builder.put("Min", BigDecimal.valueOf(monitor.getMin()).setScale(2, HALF_UP));
        builder.put("Max", BigDecimal.valueOf(monitor.getMax()).setScale(2, HALF_UP));
        builder.put("Active", monitor.getActive());
        builder.put("Avg Active", monitor.getAvgActive());
        builder.put("Max Active", monitor.getMaxActive());
        builder.put("First Access", monitor.getFirstAccess().toInstant());
        builder.put("Last Access", monitor.getLastAccess().toInstant());
        return Joiner.on(", ").withKeyValueSeparator("=").join(builder.build());
    }
}
