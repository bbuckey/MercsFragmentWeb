package dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import javax.sql.DataSource;

public abstract class BaseDAO {
	
	private SessionFactory sessionFactory;
	
	private DataSource dataSource;
	
	public BaseDAO(){;}
	
	public BaseDAO(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	public void setSessionFactory(@Qualifier("session") SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	
	public SessionFactory getSessionFactory(){
		return this.sessionFactory;
	}

	@Autowired
	public void setDataSource( DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	
	public DataSource getDataSource(){
		return this.dataSource;
	}
	

	public void cleanupConnection() throws Exception{
		if(!this.dataSource.getConnection().isClosed()){
			this.dataSource.getConnection().close();
		}
	}
	
}
