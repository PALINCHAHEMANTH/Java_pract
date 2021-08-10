package demoPack.annotation.demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

public class ExecuteApp 
{
   public static void main(String[] args) 
   {
      @SuppressWarnings("resource")
      ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

      TextEditor te = ctx.getBean(TextEditor.class);
      te.spellCheck();
   }
}