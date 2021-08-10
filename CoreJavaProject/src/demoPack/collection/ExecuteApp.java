package demoPack.collection;

import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExecuteApp 
{
   public static void main(String[] args) 
   {
      @SuppressWarnings("resource")
      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
      
      SpringCollection jc = (SpringCollection) context.getBean("injectCollection");

      List<String> list = jc.getAddressList();
      System.out.println("Address List : "+list);

      Set<String> set = jc.getAddressSet();
      System.out.println("Address Set : "+set);
      
      Map<String, String> map = jc.getAddressMap();
      System.out.println("Address Map : "+map);
      
      Properties prop = jc.getAddressProp();
      System.out.println("Address Properties : "+prop);
   }
}