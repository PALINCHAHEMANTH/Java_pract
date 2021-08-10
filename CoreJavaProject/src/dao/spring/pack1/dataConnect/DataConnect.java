package dao.spring.pack1.dataConnect;

import java.util.List;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.apache.commons.dbcp.BasicDataSource;

import dao.spring.pack1.DAO.OracleDao;
import dao.spring.pack1.domain.Person;

public class DataConnect 
{
	private DataConnect(){};

	public static void main(String[] args) throws Exception
	{
		OracleDao dao = new OracleDao();

		// Initialize the datasource, could/should be done of Spring configuration
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setDriverClassName("jdbc.oracle.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("system");
		dataSource.setPassword("root");
		
		// Inject the datasource into the dao
		dao.setDataSource(dataSource);

		dao.create(1, "Ashok", "Kumar");
		dao.create(2, "Bobby", "Deol");
		dao.create(3, "Charles", "Heston");
		dao.create(4, "Spider", "Man");
		
		System.out.println("Now select and list all persons");
	
		List<Person> list = dao.selectAll();
		
		for (Person myPerson : list) 
		{
			System.out.print(myPerson.getFirstName() + " ");
			System.out.println(myPerson.getLastName());
		}

		System.out.println("Now select and list all persons with have the firstname Lars and lastname Vogel");
		
		list = dao.select("Lars", "Vogel");
		
		for (Person myPerson : list) 
		{
			System.out.print(myPerson.getFirstName() + " ");
			System.out.println(myPerson.getLastName());
		}

		// Clean-up
		dao.deleteAll();
	}
}
