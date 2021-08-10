package demoPack.annotation.demo4;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class StartEvent implements ApplicationListener<ContextStartedEvent>
{
   public void onApplicationEvent(ContextStartedEvent event) 
   {
      System.out.println("ApplicationContext Started - Context Event Has been initiated...");
   }
}