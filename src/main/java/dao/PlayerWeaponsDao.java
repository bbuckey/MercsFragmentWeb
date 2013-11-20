package dao;

import dao.BaseDAO;

import org.springframework.stereotype.Repository;

import java.util.List;

import entity.PlayerWeaponsEntity;

@Repository
public class PlayerWeaponsDao extends BaseDAO {

	public PlayerWeaponsDao() {
		super();
	}

	public List getAllPlayerWeapons() {
		return super.getSessionFactory().getCurrentSession()
				.createQuery("from PlayerWeaponsEntity").list();
	}

	public void addPlayerWeapon(PlayerWeaponsEntity merc) {
		super.getSessionFactory().getCurrentSession().save(merc);
	}

	public void deletePlayerWeapon(Integer mercId) {
		PlayerWeaponsEntity merc = (PlayerWeaponsEntity) super
				.getSessionFactory().getCurrentSession()
				.load(PlayerWeaponsEntity.class, mercId);
		if (merc != null) {
			super.getSessionFactory().getCurrentSession().delete(merc);
		}
	}

	public List getPlayerWeaponsByPlayerID(Integer playerID) {
		return super
				.getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"from PlayerWeaponsEntity pw where pw.playerId = :pid")
				.setParameter("pid", playerID).list();
	}

}
