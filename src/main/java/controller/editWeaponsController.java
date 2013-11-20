package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import entity.WeaponsEntity;
import manager.WeaponsManager;


@Controller
@RequestMapping(value = "/weapon")
public class editWeaponsController {
	private WeaponsManager weaponsManager;

    @Autowired
    public void setWeaponsManager(WeaponsManager weaponsManager) {
        this.weaponsManager = weaponsManager;
    }
    
    public WeaponsManager getWeaponsManager(){
    	return this.weaponsManager;
    }
	
    @RequestMapping(method = RequestMethod.GET)
    public String listWeapons(ModelMap map)
    {
    	map.addAttribute("weapon", new WeaponsEntity());
        map.addAttribute("weaponsList", weaponsManager.getAllWeapons());
 
        return "editWeaponsList";
    }
    

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addWeapon(@ModelAttribute("weapon") WeaponsEntity weapon, BindingResult result)
    {	
    	weaponsManager.addWeapon(weapon);
        return "redirect:/weapon";
    }
 
    @RequestMapping("/delete/{weaponID}")
    public String deleteWeapon(@PathVariable("weaponID") Integer weaponID)
    {
    	weaponsManager.deleteWeapons(weaponID);
        return "redirect:/weapon";
    }
}
