package dao;

import dao.BaseDAO;
import entity.BattleFieldEntity;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BattleFieldDao extends BaseDAO{

	BattleFieldDao(){
		super();
	}
	
	public List getAllBattleFields(){
		return super.getSessionFactory().getCurrentSession().createQuery("from BattleFieldEntity").list();
	}
	
	public void addBattleField(BattleFieldEntity merc){
		super.getSessionFactory().getCurrentSession().save(merc);
	}
	
	public void deleteBattleField(Integer mercId){
		BattleFieldEntity merc = (BattleFieldEntity) super.getSessionFactory().getCurrentSession().load(BattleFieldEntity.class, mercId);
		if(merc != null){
			super.getSessionFactory().getCurrentSession().delete(merc);
		}
	}
	
	
	public List getBattleFieldByLevel(Integer levelNumber){
		return super.getSessionFactory().getCurrentSession()
				.createSQLQuery("select bf.id, bf.LEVEL_NUMBER from base.battefield bf where bf.level_number = :lnumber")
				.addEntity(BattleFieldEntity.class).setParameter("lnumber",levelNumber).list();
	}
	
}
