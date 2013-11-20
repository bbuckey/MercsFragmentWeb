package controller;

import manager.MercManager;
import manager.PlayerManager;
import manager.PlayerMercsManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

import entity.MercEntity;
import entity.PlayerEntity;
import entity.PlayerMercsEntity;

@Controller
@RequestMapping("/player")
public class editPlayerController {


	private PlayerManager playerManager;

    @Autowired
    public void setPlayerManager(PlayerManager playerManager) {
        this.playerManager = playerManager;
    }
    
    public PlayerManager getPlayerManager(){
    	return this.playerManager;
    }
	
    @RequestMapping(method = RequestMethod.GET)
    public String listPlayers(ModelMap map)
    {
    	map.addAttribute("player", new PlayerEntity());
        map.addAttribute("playerList", playerManager.getAllPlayers());
 
        return "editPlayerList";
    }
    

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPlayer(@ModelAttribute("player") PlayerEntity player, BindingResult result)
    {	
    	player.setLastCashTime(java.util.Calendar.getInstance().getTime());
    	playerManager.addPlayer(player);
        return "redirect:/player";
    }
 
    @RequestMapping("/delete/{playerId}")
    public String deletePlayer(@PathVariable("playerId") Integer mercId)
    {
    	playerManager.deletePlayer(mercId);
        return "redirect:/player";
    }

}
