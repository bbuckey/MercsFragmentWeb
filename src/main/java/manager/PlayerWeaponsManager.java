package manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import dao.PlayerWeaponsDao;

import entity.PlayerWeaponsEntity;

import java.util.List;

@Service
public class PlayerWeaponsManager {
	PlayerWeaponsDao playerWeaponsDao;
	
	@Autowired
	public void setPlayerWeaponsDao(PlayerWeaponsDao playerWeaponsDao){
		this.playerWeaponsDao = playerWeaponsDao;
	}
	
	public PlayerWeaponsDao getPlayerWeaponsDao(){
		return this.playerWeaponsDao;
	}
	
    @Transactional
    public void addPlayerWeapons(PlayerWeaponsEntity playerWeapon) {
    	this.playerWeaponsDao.addPlayerWeapon(playerWeapon);
    }
 
 
    @Transactional
    public List getAllPlayerWeapons() {
        return playerWeaponsDao.getAllPlayerWeapons();
    }
 
 
    @Transactional
    public void deletePlayerWeapons(Integer playerWeaponID) {
    	this.playerWeaponsDao.deletePlayerWeapon(playerWeaponID);
    }
}
