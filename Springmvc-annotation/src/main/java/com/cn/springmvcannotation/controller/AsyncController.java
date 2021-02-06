package com.cn.springmvcannotation.controller;

import java.util.UUID;
import java.util.concurrent.Callable;

import com.cn.springmvcannotation.service.DeferredResultQueue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;



@Controller
public class AsyncController {


	/**
	 * 方式②  接受的请求不能得到及时的处理		业务逻辑复杂，架构中间层(mq,各种服务等等)多等等
	 *
	 *
	 * DeferredResult processing works as follows:
	 *
	 * The controller returns a DeferredResult and saves it in some in-memory queue or list where it can be accessed.
	 *
	 * Spring MVC calls request.startAsync().
	 *
	 * Meanwhile, the DispatcherServlet and all configured filters exit the request processing thread, but the response remains open.
	 *
	 * The application sets the DeferredResult from some thread, and Spring MVC dispatches the request back to the Servlet container.
	 *
	 * The DispatcherServlet is invoked again, and processing resumes with the asynchronously produced return value.
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/createOrder")
	public DeferredResult<Object> createOrder(){
		DeferredResult<Object> deferredResult = new DeferredResult<>((long)3000, "create fail...");

		DeferredResultQueue.save(deferredResult);

		return deferredResult;
	}


	/**
	 *
	 * 专门有别的线程来监听这个队列，拿返回
	 * 这里直接模拟监听。
	 *
	 * 这里拿请求，多个线程的返回是时序和请求的时序大概率会不相同
	 * 那怎么能拿到该请求对应的返回呢？
	 * 		这个对应关系是由框架来决定的吗？todo
	 *
	 * 	只要/create 被触发，/createOrder 就能收到对应的请求？
	 *		因为请求已经交由SpringMVC来接管，我猜测的话，应该会根据线程id来打标记吧 todo
	 *
	 * DeferredResultQueue
	 *
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/create")
	public String create(){
		//创建订单
		String order = UUID.randomUUID().toString();
		DeferredResult<Object> deferredResult = DeferredResultQueue.get();
		deferredResult.setResult(order);
		return "success===>"+order;
	}


	/**
	 * 方式①
	 * 以下解释均来自官网，论看官网的重要性。。
	 *
	 * https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-async-callable

	 *The controller returns a Callable.
	 *
	 * Spring MVC calls request.startAsync() and submits the Callable to a TaskExecutor for processing in a separate thread.
	 *
	 * Meanwhile(同时), the DispatcherServlet and all filters exit the Servlet container thread, but the response remains open.
	 *
	 * Eventually the Callable produces a result, and Spring MVC dispatches the request back to the Servlet container to complete processing.
	 *
	 * The DispatcherServlet is invoked again, and processing resumes with the asynchronously produced return value from the Callable.
	 */

	/**
	 * 1、控制器返回Callable
	 * 2、SpringMVC异步处理，将Callable 提交到 TaskExecutor 使用一个隔离的线程进行执行
	 * 3、DispatcherServlet和所有的Filter退出web容器(tomcat)的线程，但是 response 保持打开状态；
	 * 4、Callable返回结果，SpringMVC将请求重新派发给容器，恢复之前的处理；
	 * 5、根据Callable返回的结果。SpringMVC继续进行视图渲染流程等（从收请求-视图渲染）。
	 *
	 * 那相当于是发送了两次请求。
	 *
	 * preHandle.../springmvc-annotation/async01
	 主线程开始...Thread[http-bio-8081-exec-3,5,main]==>1513932494700
	 主线程结束...Thread[http-bio-8081-exec-3,5,main]==>1513932494700
	 =========DispatcherServlet及所有的Filter退出线程============================

	 ================等待Callable执行==========
	 副线程开始...Thread[MvcAsync1,5,main]==>1513932494707
	 副线程开始...Thread[MvcAsync1,5,main]==>1513932496708
	 ================Callable执行完成==========

	 ================再次收到之前重发过来的请求========
	 preHandle.../springmvc-annotation/async01
	 postHandle...（Callable的之前的返回值就是目标方法的返回值）
	 afterCompletion...

	 异步的拦截器:
	 1）、原生API的AsyncListener
	 2）、SpringMVC：实现AsyncHandlerInterceptor；
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/async01")
	public Callable<String> async01(){
		System.out.println("主线程开始..."+Thread.currentThread()+"==>"+System.currentTimeMillis());

		Callable<String> callable = new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("副线程开始..."+Thread.currentThread()+"==>"+System.currentTimeMillis());
				Thread.sleep(2000);
				System.out.println("副线程开始..."+Thread.currentThread()+"==>"+System.currentTimeMillis());
				return "Callable<String> async01()";
			}
		};

		System.out.println("主线程结束..."+Thread.currentThread()+"==>"+System.currentTimeMillis());
		return callable;
	}

}
