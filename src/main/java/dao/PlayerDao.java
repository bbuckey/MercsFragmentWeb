package dao;

import dao.BaseDAO;

import org.springframework.stereotype.Repository;

import java.util.List;

import entity.PlayerEntity;
import entity.PlayerMercsEntity;

@Repository
public class PlayerDao extends BaseDAO {

	public PlayerDao() {
		super();
	}

	public List getAllPlayers() {
		return super.getSessionFactory().getCurrentSession()
				.createQuery("from PlayerEntity").list();
	}

	public void addPlayer(PlayerEntity merc) {
		super.getSessionFactory().getCurrentSession().save(merc);
	}

	public void deletePlayer(Integer playerID) {
		PlayerEntity merc = (PlayerEntity) super.getSessionFactory()
				.getCurrentSession().load(PlayerEntity.class, playerID);
		if (merc != null) {
			List pme = super
					.getSessionFactory()
					.getCurrentSession()
					.createQuery("from PlayerMercsEntity where playerId = :pid")
					.setParameter("pid", merc.getId()).list();

			if (pme != null && !pme.isEmpty()) {
				for (Object o : pme) {
					super.getSessionFactory().getCurrentSession()
							.delete("PlayerMercsEntity", (PlayerMercsEntity) o);
				}
			}

			super.getSessionFactory().getCurrentSession().delete(merc);
		}
	}

	public PlayerEntity getPlayerByID(Integer playerID) {
		PlayerEntity merc = (PlayerEntity) super.getSessionFactory()
				.getCurrentSession()
				.createQuery("from PlayerEntity where id = :meid")
				.setParameter("meid", playerID).uniqueResult();
		return merc;
	}

}
