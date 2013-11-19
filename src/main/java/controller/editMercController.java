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

import entity.MercEntity;
import manager.MercManager;

@Controller
@RequestMapping(value = "/merc")
public class editMercController {
	
	private MercManager mercManager;
	
    @Autowired
    public void setMercManager(MercManager mercManager) {
        this.mercManager = mercManager;
    }
    
    public MercManager getMercManager(){
    	return this.mercManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String listMercs(ModelMap map)
    {
    	map.addAttribute("merc", new MercEntity());
        map.addAttribute("mercList", mercManager.getAllMercs()!= null ? mercManager.getAllMercs() : null);
 
        return "editMercList";
    }
    

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addMerc(@ModelAttribute("merc") MercEntity employee, BindingResult result)
    {	
    	mercManager.addMerc(employee);
        return "redirect:/merc";
    }
 
    @RequestMapping("/delete/{mercId}")
    public String deleteMerc(@PathVariable("mercId") Integer mercId)
    {
    	mercManager.deleteMerc(mercId);
        return "redirect:/merc";
    }
    
}
