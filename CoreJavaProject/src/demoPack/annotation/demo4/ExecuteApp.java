package demoPack.annotation.demo4;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExecuteApp 
{
   public static void main(String[] args) 
   {
      @SuppressWarnings("resource")
      ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

      context.start();
	  
      HelloWorld obj = (HelloWorld) context.getBean("beanId4");
      obj.getMessage();

      context.stop();
   }
}