package dao.spring.pack1.DAO;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import dao.spring.pack1.DAO.mapper.PersonRowMapper;
import dao.spring.pack1.domain.Person;

public class OracleDao implements MyDao
{
	private DataSource dataSource;

	public void setDataSource(DataSource ds) 
	{
		dataSource = ds;
	}

	public void create(int id, String firstName, String lastName) 
	{
		JdbcTemplate enter = new JdbcTemplate(dataSource);

		enter.update("INSERT INTO PERSON (ID, FIRSTNAME, LASTNAME) VALUES(?, ?, ?)", new Object[]{id, firstName, lastName});
	}

	@SuppressWarnings("unchecked")
	public List<Person> select(String firstname, String lastname) 
	{
		JdbcTemplate select = new JdbcTemplate(dataSource);

		return select.query("select FIRSTNAME, LASTNAME from PERSON where FIRSTNAME = ? AND LASTNAME= ?", new Object[] {firstname, lastname}, new PersonRowMapper());
	}

	@SuppressWarnings("unchecked")
	public List<Person> selectAll() 
	{
		JdbcTemplate select = new JdbcTemplate(dataSource);

		return select.query("select id, FIRSTNAME, LASTNAME from PERSON", new PersonRowMapper());
	}

	public void deleteAll() 
	{
		JdbcTemplate submit = new JdbcTemplate(dataSource);
	
		submit.update("DELETE from PERSON");
	}

	public void delete(int id, String firstName, String lastName) 
	{
		JdbcTemplate del = new JdbcTemplate(dataSource);

		del.update("DELETE from PERSON where ID = ? AND LASTNAME = ?",	new Object[] { id, lastName });
	}
}
