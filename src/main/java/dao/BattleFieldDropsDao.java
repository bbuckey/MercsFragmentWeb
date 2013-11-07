package dao;

import java.util.List;

import entity.BattleFieldDropsEntity;

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
	
	public List getBattleFieldDropsByBattleFieldID(Integer battleFieldID){
		return super.getSessionFactory().getCurrentSession()
				.createSQLQuery("select bfd.id, bfd.MERCS_ID, bfd.WEAPONS_ID, bfd.BATTLEFIELD_ID from base.BattleFieldDrops bfd where bfd.battlefieldID = :bfdid")
				.addEntity(BattleFieldDropsEntity.class).setParameter("bfdid",battleFieldID).list();
	}

}
