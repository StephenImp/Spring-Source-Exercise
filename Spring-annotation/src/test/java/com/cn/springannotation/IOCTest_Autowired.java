package com.cn.springannotation;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cn.springannotation.bean.Boss;
import com.cn.springannotation.bean.Car;
import com.cn.springannotation.bean.Color;
import com.cn.springannotation.bean.Red;
import com.cn.springannotation.config.MainConifgOfAutowired;
import com.cn.springannotation.dao.BookDao;
import com.cn.springannotation.service.BookService;

public class IOCTest_Autowired {
	
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConifgOfAutowired.class);
		
		BookService bookService = applicationContext.getBean(BookService.class);
		System.out.println(bookService);
		
		//BookDao bean = applicationContext.getBean(BookDao.class);
		//System.out.println(bean);
		
		Boss boss = applicationContext.getBean(Boss.class);
		System.out.println(boss);
		Car car = applicationContext.getBean(Car.class);
		System.out.println(car);
		
		Color color = applicationContext.getBean(Color.class);
		System.out.println(color);
		System.out.println(applicationContext);
		applicationContext.close();
	}

}
