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

import entity.BattleFieldEntity;
import manager.BattleFieldManager;

@Controller
@RequestMapping(value = "/battlefield")
public class editBattleFieldController {

	private BattleFieldManager battleField;
	
    @Autowired
    public void setBattleFieldManager(BattleFieldManager battleField) {
        this.battleField = battleField;
    }
    
    public BattleFieldManager getBattleFieldManager(){
    	return this.battleField;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String listMercs(ModelMap map)
    {
    	map.addAttribute("battleField", new BattleFieldEntity());
        map.addAttribute("battleFieldList", battleField.getAllBattleFields());
 
        return "editBattleFieldList";
    }
    
    @RequestMapping(value = "/{levelNumber}", method = RequestMethod.GET)
    public String getBattleFieldByLevel(ModelMap map, @PathVariable("levelNumber") Integer levelNumber)
    {
    	
    	map.addAttribute("level", this.battleField.getBattleFieldByLevelNumber(levelNumber));
        return "editBattleField";
    }
    

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addMerc(@ModelAttribute("battleField") BattleFieldEntity battleFieldEntity, BindingResult result)
    {	
    	this.battleField.addBattleField(battleFieldEntity);
        return "redirect:/battlefield";
    }
 
    @RequestMapping("/delete/{battleFieldID}")
    public String deleteMerc(@PathVariable("battleFieldID") Integer battlfieldID)
    {
    	battleField.deleteBattleField(battlfieldID);
        return "redirect:/battlefield";
    }
    
	
}
