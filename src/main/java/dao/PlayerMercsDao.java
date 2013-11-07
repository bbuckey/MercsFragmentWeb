package dao;

import dao.BaseDAO;

import org.springframework.stereotype.Repository;

import java.util.List;

import entity.PlayerMercsEntity;

@Repository
public class PlayerMercsDao extends BaseDAO{

	public PlayerMercsDao(){
		super();
	}
	
	public List getAllPlayerMercs(){
		return super.getSessionFactory().getCurrentSession().createQuery("from PlayerMercsEntity").list();
	}
	
	public void addPlayerMerc(PlayerMercsEntity merc){
		super.getSessionFactory().getCurrentSession().save(merc);
	}
	
	public void deletePlayerMerc(Integer mercId){
		PlayerMercsEntity merc = (PlayerMercsEntity) super.getSessionFactory().getCurrentSession().load(PlayerMercsEntity.class, mercId);
		if(merc != null){
			super.getSessionFactory().getCurrentSession().delete(merc);
		}
	}
	
}
