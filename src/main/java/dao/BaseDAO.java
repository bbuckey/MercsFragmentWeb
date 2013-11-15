package dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class BaseDAO {
	
	private SessionFactory sessionFactory;
	
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


}
