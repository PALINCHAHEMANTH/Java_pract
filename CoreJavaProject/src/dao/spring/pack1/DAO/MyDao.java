package dao.spring.pack1.DAO;

import java.util.List;
import javax.sql.DataSource;

import dao.spring.pack1.domain.Person;

public interface MyDao 
{
	void setDataSource(DataSource ds);

	void create(int id, String firstName, String lastName);

	List<Person> select(String firstname, String lastname);

	List<Person> selectAll();

	void deleteAll();

	void delete(int id, String firstName, String lastName);
}