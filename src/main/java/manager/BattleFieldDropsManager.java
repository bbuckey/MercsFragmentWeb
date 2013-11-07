package manager;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import dao.BattleFieldDropsDao;
import entity.BattleFieldDropsEntity;


@Service
public class BattleFieldDropsManager {

	private BattleFieldDropsDao battleFieldDropsDao;
	

    @Transactional
    public void addBattleFieldDrops(BattleFieldDropsEntity battleFieldDrops) {
    	battleFieldDropsDao.addBattleFieldDrops(battleFieldDrops);
    }
 
 
    @Transactional
    public List getAllBattleFieldDrops() {
        return battleFieldDropsDao.getAllBattleFieldDrops();
    }
 
 
    @Transactional
    public List getBattleFieldDropsByBattleFieldID(Integer battleFieldID) {
        return battleFieldDropsDao.getBattleFieldDropsByBattleFieldID(battleFieldID);
    }
 
    
    
    @Transactional
    public void deleteBattleFieldDrops(Integer battleFieldDropsID) {
    	battleFieldDropsDao.deleteBattleFieldDrops(battleFieldDropsID);
    }

    @Autowired
    public void setBattleFieldDropsDao( BattleFieldDropsDao battleFieldDropsDao) {
        this.battleFieldDropsDao = battleFieldDropsDao;
    }
    

    public BattleFieldDropsDao getBattleFieldDropsDao() {
       return this.battleFieldDropsDao;
    }
	
	
}
