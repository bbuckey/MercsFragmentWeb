package manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.PlayerMercsDao;
import entity.PlayerMercsEntity;

import java.util.List;

@Service
public class PlayerMercsManager {

	PlayerMercsDao playerMercsDao;
	
	@Autowired
	public void setPlayerMercsDao(PlayerMercsDao playerMercsDao){
		this.playerMercsDao = playerMercsDao;
	}
	
	public PlayerMercsDao getPlayerMercsDao(){
		return this.playerMercsDao;
	}
	
    @Transactional
    public void addPlayer(PlayerMercsEntity playerMerc) {
    	this.playerMercsDao.addPlayerMerc(playerMerc);
    }
 
 
    @Transactional
    public List getAllPlayers() {
        return playerMercsDao.getAllPlayerMercs();
    }
 
    @Transactional
    public List getPlayerMercsByPlayerID(Integer playerID) {
        return playerMercsDao.getPlayerMercsByPlayerId(playerID);
    }
 
    
 
    @Transactional
    public void deletePlayer(Integer playerMercID) {
    	this.playerMercsDao.deletePlayerMerc(playerMercID);
    }
}
