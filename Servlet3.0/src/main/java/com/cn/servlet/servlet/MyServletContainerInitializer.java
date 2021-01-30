package com.cn.servlet.servlet;

import com.cn.servlet.service.HelloService;

import java.util.EnumSet;
import java.util.Set;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;


//����������ʱ��Ὣ@HandlesTypesָ�������������������ࣨʵ���࣬�ӽӿڵȣ����ݹ�����
//�������Ȥ�����ͣ�
@HandlesTypes(value={HelloService.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {

	/**
	 * Ӧ��������ʱ�򣬻�����onStartup������
	 * 
	 * Set<Class<?>> arg0������Ȥ�����͵����������ͣ�
	 * ServletContext arg1:����ǰWebӦ�õ�ServletContext��һ��WebӦ��һ��ServletContext��
	 * 
	 * 1����ʹ��ServletContextע��Web�����Servlet��Filter��Listener��
	 * 2����ʹ�ñ���ķ�ʽ������Ŀ������ʱ���ServletContext������������
	 * 		��������Ŀ������ʱ������ӣ�
	 * 		1����ServletContainerInitializer�õ���ServletContext��
	 * 		2����ServletContextListener�õ���ServletContext��
	 */
	@Override
	public void onStartup(Set<Class<?>> arg0, ServletContext sc) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("����Ȥ�����ͣ�");
		for (Class<?> claz : arg0) {
			System.out.println(claz);
		}
		
		//ע�����  ServletRegistration  
		ServletRegistration.Dynamic servlet = sc.addServlet("userServlet", new UserServlet());
		//����servlet��ӳ����Ϣ
		servlet.addMapping("/user");
		
		
		//ע��Listener
		sc.addListener(UserListener.class);
		
		//ע��Filter  FilterRegistration
		FilterRegistration.Dynamic filter = sc.addFilter("userFilter", UserFilter.class);
		//����Filter��ӳ����Ϣ
		filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
		
	}

}
