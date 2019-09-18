package com.summaryday.framework.i;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * 通过拦截器来处理系统日志，日志入库信息记录
 * 
 * 
 * <!-- 装配拦截器 -->  
 *	<mvc:interceptors>  
 *   <mvc:interceptor>  
 *  <mvc:mapping path="/*"/>  
 *      <bean class="com.datatub.springmvc.interceptors.MyInterceptors"></bean>  
 *   </mvc:interceptor>  
 *	</mvc:interceptors>
 * @author Administrator
 *
 */

public class CommonLogInterceptor extends HandlerInterceptorAdapter{
	
	/** 
     * 可以考虑作权限，日志，事务等等 
     
     * 若返回TURE,则继续调用后续的拦截器和目标方法 
     * 若返回FALSE,则不会调用后续的拦截器和目标方法 
     *  
     */  

	//该方法在目标方法调用之前被调用； 
	 public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,  
	            Object arg2) throws Exception {  
	       
	        /* 
	        *写一个日记类和Service，将需要的属性保存到数据库              
	        */  
	  
	        return true;  
	    }  
	
	//该方法在目标方法调用之后被调用； 
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		 HandlerMethod handlerMethod = (HandlerMethod) handler;  
		 //String username =  (String)request.getSession().getAttribute("user");
		 
		 Annotation[] as= handlerMethod.getMethod().getAnnotations();
		 System.out.println("MyInterceptors preHandle 调用方法名："+handlerMethod.getMethod().getName());  
	}
	
	
}
