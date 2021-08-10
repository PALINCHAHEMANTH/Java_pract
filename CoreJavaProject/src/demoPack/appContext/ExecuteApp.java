package demoPack.appContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ExecuteApp 
{
	public static void main(String[] args) 
	{
	      @SuppressWarnings("resource")
	      ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	      HelloWorld obj1 = (HelloWorld) context.getBean("appId1");
	      System.out.println(obj1.getMessage());
	      
	      System.out.println("------------------------------------");
	      obj1.setMessage("1. Welcome to CTS TreADMile Verizon Java Batch....");
	      System.out.println(obj1.getMessage());

	      System.out.println("------------------------------------");
//	      HelloWorld obj2 = (HelloWorld) context.getBean("appId1");
//	      obj2.setMessage("2. Welcome to CTS TreADMile Verizon Java Batch, Hyderabad....");
//	      System.out.println(obj2.getMessage());

//	      System.out.println(obj1.getMessage());
	      
	      System.out.println("------------------------------------");
	      @SuppressWarnings("resource")
	      ApplicationContext context1 = new FileSystemXmlApplicationContext("E:/Corporate Training 2021/IIHT/Cognizant/CTS TreADMile Verizon Java - July 28th/Core Java Topics/CoreJavaProject/src/beans.xml");
      
	      //HelloWorld obj = (HelloWorld) context1.getBean("appId1");
	      System.out.println(obj1.getMessage());

	      ((AbstractApplicationContext) context1).registerShutdownHook();
	}
}




