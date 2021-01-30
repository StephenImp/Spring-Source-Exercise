package com.cn.springannotation;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cn.springannotation.config.MainConfigOfLifeCycle;

public class IOCTest_LifeCycle {
	
	@Test
	public void test01(){
		//1������ioc����
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
		System.out.println("�����������...");
		
		//applicationContext.getBean("car");
		//�ر�����
		applicationContext.close();
	}

}
