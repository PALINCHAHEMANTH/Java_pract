package dao.spring.jdbc;

import javax.sql.DataSource;

public class JdbcDataSource
{
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}
	public DataSource getDataSource()
	{
		return dataSource;
	}
}