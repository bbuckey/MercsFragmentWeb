package manager;

import dao.WeaponsDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entity.WeaponsEntity;

import java.util.List;

@Service
public class WeaponsManager {
	WeaponsDao weaponsDao;
	
	@Autowired
	public void setWeaponsDao(WeaponsDao weaponsDao){
		this.weaponsDao = weaponsDao;
	}
	
	public WeaponsDao getWeaponsDao(){
		return this.weaponsDao;
	}
	
    @Transactional
    public void addWeapon(WeaponsEntity weapon) {
    	this.weaponsDao.addWeapon(weapon);
    }
 
 
    @Transactional
    public List getAllWeapons() {
        return weaponsDao.getAllWeapons();
    }
 
 
    @Transactional
    public WeaponsEntity getWeaponByID(Integer weaponsID) {
        return weaponsDao.getWeaponsByID(weaponsID);
    }
 
    
    @Transactional
    public void deleteWeapons(Integer weaponID) {
    	this.weaponsDao.deleteWeapon(weaponID);
    }
}
