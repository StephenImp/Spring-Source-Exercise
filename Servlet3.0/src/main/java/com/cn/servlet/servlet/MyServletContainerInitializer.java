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


//容器启动的时候会将@HandlesTypes指定的这个类型下面的子类（实现类，子接口等）传递过来；
//传入感兴趣的类型；
@HandlesTypes(value={HelloService.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {

	/**
	 * 应用启动的时候，会运行onStartup方法；
	 *
	 * Set<Class<?>> arg0：感兴趣的类型的所有子类型；
	 * ServletContext arg1:代表当前Web应用的ServletContext；一个Web应用(结合servlet四大域对象之一)一个ServletContext；
	 *
	 * application范围比较大，他是作用于整个服务端，在你启动服务器创建application对象设置值，之后在本项目中都可以获取到，
	 * 一个项目中只有一个对象，传值的时候根据键的不同区分，application在服务器关闭的时候销毁，
	 *
	 * 生命周期：
	 *
	 *     当WEB应用被加载进容器创建代表整个WEB应用的ServletContext对象
	 *     当服务器关闭或WEB应用被移除时，ServletContext对象跟着被销毁。
	 *
	 *
	 * 1）、使用ServletContext注册Web组件（Servlet、Filter、Listener）
	 * 2）、使用编码的方式，在项目启动的时候给ServletContext里面添加组件；
	 * 		必须在项目启动的时候来添加；
	 * 		1）、ServletContainerInitializer得到的ServletContext；
	 * 		2）、ServletContextListener得到的ServletContext；
	 */
	@Override
	public void onStartup(Set<Class<?>> arg0, ServletContext sc) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("感兴趣的类型：");
		for (Class<?> claz : arg0) {
			System.out.println(claz);
		}

		/**
		 * 	使用ServletContext注册Web组件（Servlet、Filter、Listener）
		 */

		//注册组件  ServletRegistration
		ServletRegistration.Dynamic servlet = sc.addServlet("userServlet", new UserServlet());
		//配置servlet的映射信息
		servlet.addMapping("/user");


		//注册Listener
		sc.addListener(UserListener.class);

		//注册Filter  FilterRegistration
		FilterRegistration.Dynamic filter = sc.addFilter("userFilter", UserFilter.class);
		//配置Filter的映射信息
		filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");

	}

}
