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
public class editMercController {
	
	private MercManager mercManager;
	
    @Autowired
    public void setMercManager(MercManager mercManager) {
        this.mercManager = mercManager;
    }
    
    public MercManager getMercManager(){
    	return this.mercManager;
    }

    @RequestMapping(value = "/merc", method = RequestMethod.GET)
    public String listEmployees(ModelMap map)
    {
    	map.addAttribute("merc", new MercEntity());
        map.addAttribute("mercList", mercManager.getAllMercs()!= null ? mercManager.getAllMercs() : null);
 
        return "editMercList";
    }
    

    @RequestMapping(value = "/merc/add", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute("merc") MercEntity employee, BindingResult result)
    {	
    	mercManager.addMerc(employee);
        return "redirect:/MercsFragmentWebWAR";
    }
 
    @RequestMapping("/merc/delete/{mercId}")
    public String deleteEmplyee(@PathVariable("mercId") Integer mercId)
    {
    	mercManager.deleteMerc(mercId);
        return "redirect:/MercsFragmentWebWAR";
    }
    
}
