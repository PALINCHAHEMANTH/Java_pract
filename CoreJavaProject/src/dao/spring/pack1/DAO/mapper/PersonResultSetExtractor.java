package dao.spring.pack1.DAO.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.ResultSetExtractor;

import dao.spring.pack1.domain.Person;

@SuppressWarnings("rawtypes")
public class PersonResultSetExtractor implements ResultSetExtractor 
{
	public Object extractData(ResultSet rs) throws SQLException 
	{
		Person person = new Person();
	
		person.setId(rs.getInt(1));
		person.setFirstName(rs.getString(2));
		person.setLastName(rs.getString(3));
		
		return person;
	}
}