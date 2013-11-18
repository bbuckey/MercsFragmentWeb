package controller;

import manager.PlayerManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

import entity.PlayerEntity;

@Controller
public class editPlayerController {

	private PlayerManager playerManager;
	
    @Autowired
    public void setPlayerManager(PlayerManager playerManager) {
        this.playerManager = playerManager;
    }
    
    public PlayerManager getPlayerManager(){
    	return this.playerManager;
    }

    @RequestMapping(value = "/player", method = RequestMethod.GET)
    public String listEmployees(ModelMap map)
    {
    	map.addAttribute("player", new PlayerEntity());
        map.addAttribute("playerList", playerManager.getAllPlayers());
 
        return "editPlayerList";
    }
    

    @RequestMapping(value = "/player/add", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute("player") PlayerEntity employee, BindingResult result)
    {	
    	playerManager.addPlayer(employee);
        return "redirect:/player";
    }
 
    @RequestMapping("/player/delete/{playerId}")
    public String deleteEmplyee(@PathVariable("playerId") Integer mercId)
    {
    	playerManager.deletePlayer(mercId);
        return "redirect:/player";
    }
	
}
