package demoPack.additional.util;

import org.springframework.beans.factory.*;
import org.springframework.beans.factory.xml.*;
import org.springframework.core.io.*;

public class TeamIndia 
{
	public static void main(String[] args) 
	{
		Resource resource = new FileSystemResource("src/player-team.xml");
		@SuppressWarnings("deprecation")
		BeanFactory factory = new XmlBeanFactory(resource);

		Team india = (Team)factory.getBean("india");
		System.out.println(india);

		Player tendulkar = (Player)factory.getBean("tendulkar");
		System.out.println(tendulkar);

		Player dravid = (Player)factory.getBean("dravid");
		System.out.println(dravid);

		Player ganguly = (Player)factory.getBean("ganguly");
		System.out.println(ganguly);
	}
}