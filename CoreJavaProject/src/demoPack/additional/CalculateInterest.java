package demoPack.additional;

import org.springframework.beans.factory.*;
import org.springframework.beans.factory.xml.*;
import org.springframework.core.io.*;

public class CalculateInterest 
{
	public static void main(String[] args) throws Exception
	{
		Resource res = new ClassPathResource("beans.xml");

		@SuppressWarnings("deprecation")
		BeanFactory factory = new XmlBeanFactory(res);

		CompoundInterestBean interest = (CompoundInterestBean) factory.getBean("beanId1");

		System.out.println("The Interest Applicable : "+interest.getInterest());
	}
}