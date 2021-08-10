package demoPack.additional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ACExample 
{
	public static void main( String[] args ) throws Exception
	{
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ContextService service = (ContextService) context.getBean("appContextService");
		
		service.printClassProperty();
	}
}