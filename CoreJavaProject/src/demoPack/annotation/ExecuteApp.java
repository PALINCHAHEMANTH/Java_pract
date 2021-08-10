package demoPack.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

public class ExecuteApp 
{
   public static void main(String[] args) 
   {
      @SuppressWarnings("resource")
      ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
   
      HelloWorld hw = ctx.getBean(HelloWorld.class);
      
      hw.setMessage("Welcome to Annotation based Spring Framework");

      System.out.println(hw.getMessage());
   }
}