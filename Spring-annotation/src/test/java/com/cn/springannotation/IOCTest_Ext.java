package com.cn.springannotation;

import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cn.springannotation.aop.MathCalculator;
import com.cn.springannotation.bean.Boss;
import com.cn.springannotation.bean.Car;
import com.cn.springannotation.bean.Color;
import com.cn.springannotation.bean.Red;
import com.cn.springannotation.config.MainConfigOfAOP;
import com.cn.springannotation.config.MainConifgOfAutowired;
import com.cn.springannotation.dao.BookDao;
import com.cn.springannotation.ext.ExtConfig;
import com.cn.springannotation.service.BookService;


/**
 * Spring 的拓展原理
 */
public class IOCTest_Ext {

	@Test
	public void test01(){

		AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext(ExtConfig.class);


		//发布事件；
		applicationContext.publishEvent(new ApplicationEvent(new String("我发布的事件")) {});

		applicationContext.close();
	}

}
