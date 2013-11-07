package dao;

import dao.BaseDAO;

import org.springframework.stereotype.Repository;

import java.util.List;

import entity.PlayerEntity;

@Repository
public class PlayerDao extends BaseDAO {

	public PlayerDao(){
		super();
	}
	
	public List getAllPlayers(){
		return super.getSessionFactory().getCurrentSession().createQuery("from PlayerEntity").list();
	}
	
	public void addPlayer(PlayerEntity merc){
		super.getSessionFactory().getCurrentSession().save(merc);
	}
	
	public void deletePlayer(Integer mercId){
		PlayerEntity merc = (PlayerEntity) super.getSessionFactory().getCurrentSession().load(PlayerEntity.class, mercId);
		if(merc != null){
			super.getSessionFactory().getCurrentSession().delete(merc);
		}
	}
	
	public PlayerEntity getPlayerByID(Integer playerID){
		PlayerEntity merc = (PlayerEntity) super.getSessionFactory().getCurrentSession().createQuery("from PlayerEntity where id = :meid").setParameter("meid", playerID).uniqueResult();
		return merc;
	}
	
}
