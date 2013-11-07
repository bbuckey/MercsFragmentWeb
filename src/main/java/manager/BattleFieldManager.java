package manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.BattleFieldDao;
import entity.BattleFieldEntity;

@Service
public class BattleFieldManager {

	private BattleFieldDao battleFieldDao;
	

    @Transactional
    public void addBattleField(BattleFieldEntity battleField) {
    	battleFieldDao.addBattleField(battleField);
    }
 
 
    @Transactional
    public List getAllBattleFields() {
        return battleFieldDao.getAllBattleFields();
    }
 
 
    @Transactional
    public List getBattleFieldByLevelNumber( Integer levelNumber) {
        return battleFieldDao.getBattleFieldByLevel(levelNumber);
    }
 
    
    @Transactional
    public void deleteBattleField(Integer battleFieldID) {
    	battleFieldDao.deleteBattleField(battleFieldID);
    }

    @Autowired
    public void setBattleFieldDao( BattleFieldDao battleFieldDao) {
        this.battleFieldDao = battleFieldDao;
    }
    

    public BattleFieldDao getBattleFieldDao() {
       return this.battleFieldDao;
    }
	
	
}
