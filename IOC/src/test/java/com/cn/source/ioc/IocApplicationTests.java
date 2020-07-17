package com.cn.source.ioc;

import com.cn.source.ioc.service.IOCService;
import com.cn.source.ioc.service.impl.IOCServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class IocApplicationTests {

    @Autowired
    private IOCServiceImpl iocService;

    @Test
    public void demo() {
        System.out.println(iocService.hello());

        //看名字就可以知道它们哥俩都是通过加载配置文件来启动Spring的，只不过一个是从程序内加载一个是从系统内加载。
        //ClassPathXmlApplicationContext
        //FileSystemXmlApplicationContext

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-ioc.xml");
        IOCService iocService=context.getBean(IOCService.class);
        System.out.println(iocService.hello());


        //AnnotationConfigApplicationContext  这个类是用来处理注解式编程的
    }

}
