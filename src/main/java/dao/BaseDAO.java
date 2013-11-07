package dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDAO {
	
	private SessionFactory sessionFactory;
	
	public BaseDAO(){;}
	
	public BaseDAO(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	
	public SessionFactory getSessionFactory(){
		return this.sessionFactory;
	}


}
