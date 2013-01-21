/*
 * This code is Copyright (c) 2013 Atomic Axis. All rights reserved.
 * You are not allowed to remember or reproduce anything you read below.
 * Author: Gene Fojtik
 * Date: 1/21/2013 
 * 
 */

package com.test.interceptor.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggerInterceptor extends HandlerInterceptorAdapter {

	static Logger logger = Logger.getLogger(LoggerInterceptor.class);

	static{
		BasicConfigurator.configure();
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		logger.info("Before handling the request");
		System.out.println("Calling preHandle");
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("After handling the request");
		System.out.println("Calling postHandle");
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("After rendering the view");
		System.out.println("Calling afterCompletion");
		super.afterCompletion(request, response, handler, ex);
	}
	
	
	
}