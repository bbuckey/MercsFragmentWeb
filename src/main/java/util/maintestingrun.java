package util;

import manager.MercManager;

import entity.MercEntity;

import java.util.List;


import util.SpringBeanContextFactory;

public class maintestingrun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MercManager mm = (MercManager)SpringBeanContextFactory.loadXmlBeanResources().getBean("mercManager");
		
		List<MercEntity> mlist = mm.getAllMercs();
		
		for(MercEntity me : mlist){
			System.err.println(me.getAtk() + " " + me.getDef() + " " + me.getHp() + " "+ me.getId() + " " + me.getMercName());
		}

		
		for(MercEntity me : mlist){
			System.err.println(me.getAtk() + " " + me.getDef() + " " + me.getHp() + " "+ me.getId() + " " + me.getMercName());
		}
	
	}

}
