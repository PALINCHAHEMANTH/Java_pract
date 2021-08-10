package demoPack.annotation.demo2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class ExecuteApp 
{
	public static void main(String[] args) 
	{
	   @SuppressWarnings("resource")
	   AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigB.class);
	   
	   A a = ctx.getBean(A.class);
	   a.display();
	   
	   System.out.println("---------------------");

	   B b = ctx.getBean(B.class);
	   b.display();

       ctx.registerShutdownHook();
	}
}