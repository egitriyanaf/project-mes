package com.agit.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 *
 * @author erwin
 */
@Service
public class SpringUtil implements ApplicationContextAware {
	
	private static ApplicationContext context;

    /**
     *
     * @param ctx
     * @throws org.springframework.beans.BeansException
     */
    public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		context = ctx;
	}

    /**
     *
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
		return context.getBean(beanName);
	}
	
    /**
     *
     * @param beanClass
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object getBean(Class beanClass){
		return context.getBean(beanClass);
	}
	
}
