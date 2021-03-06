package com.cn.springannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.springannotation.bean.Person;
import com.cn.springannotation.config.MainConfig;

public class MainTest {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		/**
		 * 配置文件获取
		 */
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//		Person bean = (Person) applicationContext.getBean("person");
//		System.out.println(bean);

		/**
		 * @Bean 注解
		 */
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		Person bean = applicationContext.getBean(Person.class);
		System.out.println(bean);
//

//		String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
//		for (String name : namesForType) {
//			System.out.println(name);
//		}
	
	}

}
