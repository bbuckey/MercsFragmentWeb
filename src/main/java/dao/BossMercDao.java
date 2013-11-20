package dao;

import dao.BaseDAO;
import entity.BossMercEntity;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BossMercDao extends BaseDAO {

	BossMercDao() {
		super();
	}

	public List getAllBossMercs() {
		return super.getSessionFactory().getCurrentSession()
				.createQuery("from BossMercEntity").list();
	}

	public void addBossMerc(BossMercEntity merc) {
		super.getSessionFactory().getCurrentSession().save(merc);
	}

	public void deleteBossMerc(Integer mercId) {
		BossMercEntity merc = (BossMercEntity) super.getSessionFactory()
				.getCurrentSession().load(BossMercEntity.class, mercId);
		if (merc != null) {
			super.getSessionFactory().getCurrentSession().delete(merc);
		}
	}

	public List getBossMercByBattleFieldID(Integer battleFieldID) {
		return super
				.getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"from BossMercEntity bm where bm.battlefieldId = :bfid")
				.setParameter("bfid", battleFieldID).list();
	}
}
