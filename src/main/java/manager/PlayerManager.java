package manager;

import dao.PlayerDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entity.PlayerEntity;

import java.util.List;

@Service
public class PlayerManager {
	
	PlayerDao playerDao;

	@Autowired
	public void setPlayerDao(PlayerDao playerDao){
		this.playerDao = playerDao;
	}
	
	public PlayerDao getPlayerDao(){
		return this.playerDao;
	}
	
	
    @Transactional
    public void addPlayer(PlayerEntity player) {
    	this.playerDao.addPlayer(player);
    }
 
 
    @Transactional
    public List getAllPlayers() {
        return playerDao.getAllPlayers();
    }
 
 
    @Transactional
    public void deletePlayer(Integer playerID) {
    	this.playerDao.deletePlayer(playerID);
    }

}
