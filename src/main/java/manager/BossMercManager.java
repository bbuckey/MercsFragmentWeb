package manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import dao.BossMercDao;
import entity.BossMercEntity;

@Service
public class BossMercManager {

	private BossMercDao bossMercDao;
	

    @Transactional
    public void addBossMerc(BossMercEntity bossMercEntity) {
    	bossMercDao.addBossMerc(bossMercEntity);
    }
 
 
    @Transactional
    public List getAllBossMercs() {
        return bossMercDao.getAllBossMercs();
    }
    
    @Transactional
    public List getBossMercsByBattleFieldID(Integer battleFieldID) {
        return bossMercDao.getBossMercByBattleFieldID(battleFieldID);
    }
 
 
 
    @Transactional
    public void deleteBossMerc(Integer bossMercID) {
    	bossMercDao.deleteBossMerc(bossMercID);
    }

    @Autowired
    public void setBossMercDao( BossMercDao bossMercDao) {
        this.bossMercDao = bossMercDao;
    }
    

    public BossMercDao getBossMercDao(){
       return this.bossMercDao;
    }
	
    
    
	
}
