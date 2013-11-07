package dao;

import java.util.List;

import entity.BattleFieldDropsEntity;;

public class BattleFieldDropsDao extends dao.BaseDAO{
	
	BattleFieldDropsDao(){
		super();
	}
	
	public List getAllBattleFieldDrops(){
		return super.getSessionFactory().getCurrentSession().createQuery("from BattleFieldDropsEntity").list();
	}
	
	public void addBattleFieldDrops(BattleFieldDropsEntity merc){
		super.getSessionFactory().getCurrentSession().save(merc);
	}
	
	public void deleteBattleFieldDrops(Integer mercId){
		BattleFieldDropsEntity merc = (BattleFieldDropsEntity) super.getSessionFactory().getCurrentSession().load(BattleFieldDropsEntity.class, mercId);
		if(merc != null){
			super.getSessionFactory().getCurrentSession().delete(merc);
		}
	}
	

}
