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
	
	public List getAllPlayerWeapons(){
		return super.getSessionFactory().getCurrentSession().createQuery("from WeaponsEntity").list();
	}
	
	public void addPlayerWeapon(WeaponsEntity merc){
		super.getSessionFactory().getCurrentSession().save(merc);
	}
	
	public void deletePlayerWeapon(Integer mercId){
		WeaponsEntity merc = (WeaponsEntity) super.getSessionFactory().getCurrentSession().load(WeaponsEntity.class, mercId);
		if(merc != null){
			super.getSessionFactory().getCurrentSession().delete(merc);
		}
	}
	
	
}
