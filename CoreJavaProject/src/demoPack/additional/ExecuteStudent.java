package demoPack.additional;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@SuppressWarnings("deprecation")
public class ExecuteStudent 
{
	public static void main(String[] args) 
	{
		Resource res = new FileSystemResource("src/applicationContext.xml");

		BeanFactory factory = new XmlBeanFactory(res);        
		
		StudentBean sbean = (StudentBean) factory.getBean("beanId2");
		
		//System.out.println(sbean.getStudId() +" "+sbean.getStudName()+" "+sbean.getMarks());

		System.out.println(sbean.studId +" "+sbean.studName+" "+sbean.marks);
	}
}