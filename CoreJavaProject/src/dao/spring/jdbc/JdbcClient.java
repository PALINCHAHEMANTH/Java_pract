package dao.spring.jdbc;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.*;
import org.springframework.beans.factory.xml.*;
import org.springframework.core.io.*;
import org.springframework.jdbc.core.*;

public class JdbcClient
{
	@SuppressWarnings("rawtypes")
	public static void main(String args[])
	{
		try
 		{
			Resource res = new ClassPathResource("beans.xml");
 	
			@SuppressWarnings("deprecation")
			BeanFactory factory = new XmlBeanFactory(res);
 			
			JdbcDataSource bean = (JdbcDataSource)factory.getBean("dao");
 			
			JdbcTemplate template = new JdbcTemplate(bean.getDataSource());
 			
			if("select".equalsIgnoreCase(args[0]))
 			{
				List list = template.queryForList("select * from Employee");

				Iterator i = list.iterator();
 		
				while(i.hasNext())
 				{
 					Object ob = i.next();
 					System.out.println(ob);
 				}
 			}
			/*if("delete".equalsIgnoreCase(args[0]))
 			{
 				template.execute("Delete from Employee where id ='"+args[1]+"'");
 			}*/
 		}
		catch(Exception e){
			e.printStackTrace();
		}
 	}
}