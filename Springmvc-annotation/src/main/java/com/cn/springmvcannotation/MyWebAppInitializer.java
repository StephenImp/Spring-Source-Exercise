package com.cn.springmvcannotation;

import com.cn.springmvcannotation.config.AppConfig;
import com.cn.springmvcannotation.config.RootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



//web����������ʱ�򴴽����󣻵��÷�������ʼ��������ǰǰ�˿�����
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	//��ȡ�������������ࣻ��Spring�������ļ���   ��������
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[]{RootConfig.class};
	}

	//��ȡweb�����������ࣨSpringMVC�����ļ���  ��������
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[]{AppConfig.class};
	}

	//��ȡDispatcherServlet��ӳ����Ϣ
	//  /�������������󣨰�����̬��Դ��xx.js,xx.png���������ǲ�����*.jsp��
	//  /*����������������*.jspҳ�涼���أ�jspҳ����tomcat��jsp��������ģ�
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"/"};
	}

}
