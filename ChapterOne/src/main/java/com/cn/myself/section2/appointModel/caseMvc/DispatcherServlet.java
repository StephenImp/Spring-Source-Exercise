package com.cn.myself.section2.appointModel.caseMvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//相当于项目经理的角色
public class DispatcherServlet extends HttpServlet {

    private List<Handler> handlerMapping = new ArrayList<>();

    public void init() throws ServletException{

        try {
            Class<?> memberControllerClass = MemberController.class;
            Handler handler = new Handler();
            handler.setController(memberControllerClass.newInstance());
            handler.setMethod(memberControllerClass.getMethod("getMemberById"),new Class[]{String.class});
            handler.setUrl("/web/getMemberById.json");
            handlerMapping.add(handler);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception{

        /**
         * 方法①
         */
//        String url = request.getRequestURI();
//        String mid = request.getParameter("mid");
//
//        if ("getMemberById".equals(url)){
//            new MemberController().getMemberById(mid);
//        }else if ("getOrderById".equals(url)){
//            new OrderController().getOrderById(mid);
//        }else if ("logout".equals(url)){
//            new SystemController().logout();
//        }else {
//            response.getWriter().write("404 Not Found!! ");
//        }


        /**
         * 方法二
         */
        //获取用户请求的url
        //Servlet 拿到URL 以后，做权衡,找到这个url对应的java类的方法
        String url = request.getRequestURI();
        Handler handler = null;
        //通过获取的URL去做 handlerMapping  （我们认为他是策略常量）
        for (Handler h:handlerMapping){
            if (url.equals(h.getUrl())){
                handler = h;
                break;
            }
        }

        //将具体的任务分发给Method(通过反射调用对应的方法)
        Object object = null;
        object = handler.getMethod().invoke(handler.getController(),request.getParameter("mid"));
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
