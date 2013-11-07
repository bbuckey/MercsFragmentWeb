package dao;

import dao.BaseDAO;
import org.springframework.stereotype.Repository;
import java.util.List;
import entity.MercEntity;

@Repository
public class MercsDao extends BaseDAO {


	public MercsDao(){
		super();
	}
	
	public List getAllMercs(){
		return super.getSessionFactory().getCurrentSession().createQuery("from MercEntity").list();
	}
	
	public void addMerc(MercEntity merc){
		super.getSessionFactory().getCurrentSession().save(merc);
	}
	
	public void deleteMerc(Integer mercId){
		MercEntity merc = (MercEntity) super.getSessionFactory().getCurrentSession().load(MercEntity.class, mercId);
		if(merc != null){
			super.getSessionFactory().getCurrentSession().delete(merc);
		}
	}
	
	
	public MercEntity getMercByID(Integer mercId){
		MercEntity merc = (MercEntity) super.getSessionFactory().getCurrentSession()
				.createQuery("from MercEntity me where me.id = :meid ").setParameter("meid", mercId).uniqueResult();
		return merc;
	}
	
}
