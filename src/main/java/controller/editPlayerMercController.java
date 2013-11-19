package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import manager.PlayerManager;
import manager.PlayerMercsManager;
import manager.MercManager;
import entity.PlayerMercsEntity;
import entity.PlayerEntity;
import entity.MercEntity;

@Controller
@RequestMapping("/player/merc")
public class editPlayerMercController {

	private PlayerMercsManager playerMercsManager;
	private PlayerManager playerManager;
	private MercManager mercManager;
	
    @Autowired
    public void setMercManager(MercManager mercManager) {
        this.mercManager = mercManager;
    }
    
    public MercManager getMercManager(){
    	return this.mercManager;
    }
	
	@Autowired
	public void setPlayerMercsManager(PlayerMercsManager playerMercsManager){
		this.playerMercsManager = playerMercsManager;
	}
	
	public PlayerMercsManager getPlayerMercsManager(){
		return this.playerMercsManager;
	}
	
    @Autowired
    public void setPlayerManager(PlayerManager playerManager) {
        this.playerManager = playerManager;
    }
    
    public PlayerManager getPlayerManager(){
    	return this.playerManager;
    }
	
	
    @RequestMapping(value = "/{playerId}", method = RequestMethod.GET)
    public String listPlayerMerc(ModelMap map,@PathVariable("playerId") Integer playerId)
    {
    	map.addAttribute("player",playerManager.getPlayerByplayerID(playerId));
        map.addAttribute("playerMercList", playerMercsManager.getPlayerMercsByPlayerID(playerId));
        map.addAttribute("mercList",mercManager.getAllMercs());
 
        return "editPlayerMerc";
    }
    

    @RequestMapping(value = "/add/{playerid}/{mercId}")
    public String addPlayerMerc(@PathVariable("playerid") Integer playerId, 
    		@PathVariable("mercId") Integer mercId)
    {	
    	PlayerMercsEntity playerMerc =  new PlayerMercsEntity();
    	MercEntity me = mercManager.getMercByID(mercId);
    	playerMerc.setPlayerId(playerId);
    	playerMerc.setMercId(me.getId());
    	playerMerc.setAtk(me.getAtk());
    	playerMerc.setHp(me.getHp());
    	playerMerc.setDef(me.getDef());
    	playerMerc.setLevel(1);
    	playerMerc.setMercName(me.getMercName());
    	playerMercsManager.addPlayerMerc(playerMerc);
        return "redirect:/player/merc/" + String.valueOf(playerId);
    }
 
    @RequestMapping("/delete/{playerId}/{playerMercId}")
    public String deletePlayerMerc(@PathVariable("playerMercId") Integer mercId,@PathVariable("playerId") Integer player)
    {
    	playerMercsManager.deletePlayer(mercId);
    	return "redirect:/player/merc/" + String.valueOf(player);
    }
	
}
