package com.gzhu.bm.aop;

import java.util.Date;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;
 

/**
 * 对DAO插入和更新方法的拦截，并设置公共字段的信息
 * 
 * 
 */
@Component
@Aspect
public class DealTimeAop {

    
     
    private static final String CREATED_TIME   = "createdTime";
    private static final String UPDATED_TIME = "updatedTime";
    
    @Pointcut("execution(* com.gzhu.bm.service..*.create*(..))")
    public void pointcutInsert(){}
    
    @Pointcut("execution(* com.gzhu.bm.service..*.update*(..))")
    public void pointcutUpdate(){}
   
    @Before("pointcutInsert()")
    public void beforeInsert(JoinPoint jp) {
    	System.out.println("before-----------------insert");
        Object[] args = jp.getArgs();

        if (args != null && args.length > 0) {
            Object argument = args[0];
            BeanWrapper beanWrapper = new BeanWrapperImpl(argument);
            // 设置创建时间和修改时间
            if (beanWrapper.isWritableProperty(CREATED_TIME)) {
                beanWrapper.setPropertyValue(CREATED_TIME, new Date());
            }
            if (beanWrapper.isWritableProperty(UPDATED_TIME)) {
                beanWrapper.setPropertyValue(UPDATED_TIME, new Date());
            }
           
        }
    }

    @Before("pointcutUpdate()")
    public void beforeUpdate(JoinPoint jp) {
    	System.out.println("before-----------------update");
        Object[] args = jp.getArgs();

        if (args != null && args.length > 0) {
            Object argument = args[0];
            if (argument instanceof Map) {
                Map map = (Map) argument;
                map.put(UPDATED_TIME, new Date());
            }else{    
	            BeanWrapper beanWrapper = new BeanWrapperImpl(argument);
	            // 设置创建时间和修改时间
	            if (beanWrapper.isWritableProperty(UPDATED_TIME)) {
	                beanWrapper.setPropertyValue(UPDATED_TIME, new Date());
	            } 
            }
        }
    }
   
}