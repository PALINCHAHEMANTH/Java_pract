package demoPack.annotation.demo4;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

public class StopEvent implements ApplicationListener<ContextStoppedEvent>
{
   public void onApplicationEvent(ContextStoppedEvent event) 
   {
      System.out.println("ApplicationContext Stopped - when thid EVENT which has raised...");
   }
}