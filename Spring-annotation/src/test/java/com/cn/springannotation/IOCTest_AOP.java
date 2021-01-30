package com.cn.springannotation;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cn.springannotation.aop.MathCalculator;
import com.cn.springannotation.bean.Boss;
import com.cn.springannotation.bean.Car;
import com.cn.springannotation.bean.Color;
import com.cn.springannotation.bean.Red;
import com.cn.springannotation.config.MainConfigOfAOP;
import com.cn.springannotation.config.MainConifgOfAutowired;
import com.cn.springannotation.dao.BookDao;
import com.cn.springannotation.service.BookService;

public class IOCTest_AOP {
	
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
		
		//1����Ҫ�Լ���������
//		MathCalculator mathCalculator = new MathCalculator();
//		mathCalculator.div(1, 1);
		MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
		
		mathCalculator.div(1, 0);
		
		applicationContext.close();
	}

}
