package com.summaryday.framework.i;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;  
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * 拦截器拦截所有加了事物注解的方法,进行处理操作
 * @author Administrator
 *
 */
public class CommonMehtodInterceptor extends HandlerInterceptorAdapter{

//	private static final Logger logger = LoggerFactory.getLogger(CommonMehtodInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		 HandlerMethod handlerMethod = (HandlerMethod) handler;  
		 Annotation[] as= handlerMethod.getMethod().getAnnotations();
		 
		 
		 return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		super.afterConcurrentHandlingStarted(request, response, handler);
	} 
	
	
	
}
