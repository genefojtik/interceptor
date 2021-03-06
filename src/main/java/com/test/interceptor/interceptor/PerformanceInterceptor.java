/*
 * This code is Copyright (c) 2013 Atomic Axis. All rights reserved.
 * You are not allowed to remember or reproduce anything you read below.
 * Author: Gene Fojtik
 * Date: 1/21/2013 
 * 
 */

package com.test.interceptor.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PerformanceInterceptor implements MethodInterceptor {

	public Object invoke(MethodInvocation method) throws Throwable {
		long startTime = System.currentTimeMillis();
		try {
			Object result = method.proceed();
			return result;
		} finally {
			long endTime = System.currentTimeMillis();
			long executionTime = endTime - startTime;
			System.out.println("Method Name: " + method.getMethod().getName()
					+ " Execution Time:- " + executionTime + " ms");
		}
	}
}