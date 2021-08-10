package demoPack.beanFactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory; 
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;  

@SuppressWarnings("deprecation")
public class ExecuteApp 
{
	public static void main(String[] args) 
	{
		Resource res = new ClassPathResource("beans.xml");
		BeanFactory factory = new XmlBeanFactory (res); 
		HelloWorld obj = (HelloWorld) factory.getBean("appId2");    
	    obj.getMessage();

	    System.out.println("------------------------------------");
	    obj.setMessage("CTS TreADMile Verizon Java Batch....");
	    obj.getMessage();
	}
}
