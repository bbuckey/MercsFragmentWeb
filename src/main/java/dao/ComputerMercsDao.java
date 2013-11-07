package dao;

import java.util.List;

import entity.ComputerMercsEntity;
import org.springframework.stereotype.Repository;
import dao.BaseDAO;

@Repository
public class ComputerMercsDao extends BaseDAO{
	ComputerMercsDao(){
		super();
	}
	
	public List getAllComputerMercs(){
		return super.getSessionFactory().getCurrentSession().createQuery("from ComputerMercsEntity").list();
	}
	
	public void addComputerMercs(ComputerMercsEntity merc){
		super.getSessionFactory().getCurrentSession().save(merc);
	}
	
	public void deleteComputerMercs(Integer mercId){
		ComputerMercsEntity merc = (ComputerMercsEntity) super.getSessionFactory().getCurrentSession().load(ComputerMercsEntity.class, mercId);
		if(merc != null){
			super.getSessionFactory().getCurrentSession().delete(merc);
		}
	}
	
	public List getComputerMercbyBattleFieldID(Integer battleFieldID){
		return super.getSessionFactory().getCurrentSession()
				.createQuery("from ComputerMercsEntity cm  where cm.battlefield_id = :bfid").setParameter("bfid", battleFieldID).list();
	}
	
}
