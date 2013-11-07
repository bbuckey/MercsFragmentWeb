package dao;


import dao.BaseDAO;

import org.springframework.stereotype.Repository;

import java.util.List;

import entity.WeaponsEntity;

@Repository
public class WeaponsDao extends BaseDAO{

	public WeaponsDao(){
		super();
	}
	
	public List getAllWeapons(){
		return super.getSessionFactory().getCurrentSession().createQuery("from WeaponsEntity").list();
	}
	
	public void addWeapon(WeaponsEntity merc){
		super.getSessionFactory().getCurrentSession().save(merc);
	}
	
	public void deleteWeapon(Integer mercId){
		WeaponsEntity merc = (WeaponsEntity) super.getSessionFactory().getCurrentSession().load(WeaponsEntity.class, mercId);
		if(merc != null){
			super.getSessionFactory().getCurrentSession().delete(merc);
		}
	}
	
	public WeaponsEntity getWeaponsByID(Integer weaponsID){
		WeaponsEntity merc = (WeaponsEntity) super.getSessionFactory().getCurrentSession().load(WeaponsEntity.class, weaponsID);
		return merc;
	}
	
	
	
}
