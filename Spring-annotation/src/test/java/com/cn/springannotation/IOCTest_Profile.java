package com.cn.springannotation;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cn.springannotation.bean.Boss;
import com.cn.springannotation.bean.Car;
import com.cn.springannotation.bean.Color;
import com.cn.springannotation.bean.Red;
import com.cn.springannotation.bean.Yellow;
import com.cn.springannotation.config.MainConfigOfProfile;
import com.cn.springannotation.config.MainConifgOfAutowired;
import com.cn.springannotation.dao.BookDao;
import com.cn.springannotation.service.BookService;

public class IOCTest_Profile {
	
	//1��ʹ�������ж�̬����: �����������λ�ü��� -Dspring.profiles.active=test
	//2������ķ�ʽ����ĳ�ֻ�����
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext();
		//1������һ��applicationContext
		//2��������Ҫ����Ļ���
		applicationContext.getEnvironment().setActiveProfiles("dev");
		//3��ע����������
		applicationContext.register(MainConfigOfProfile.class);
		//4������ˢ������
		applicationContext.refresh();
		
		
		String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
		for (String string : namesForType) {
			System.out.println(string);
		}
		
		Yellow bean = applicationContext.getBean(Yellow.class);
		System.out.println(bean);
		applicationContext.close();
	}

}
