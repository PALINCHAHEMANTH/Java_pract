package demoPack.annotation.demo3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExecuteApp 
{
   public static void main(String[] args) 
   {
      @SuppressWarnings("resource")
      AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

      HelloWorld obj = (HelloWorld) context.getBean("beanId3");
      obj.getMessage();
      
      context.registerShutdownHook();
   }
}