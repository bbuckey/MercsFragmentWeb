package util;

import manager.MercManager;
import entity.MercEntity;
import entity.ComputerMercsEntity;
import entity.BossMercEntity;
import manager.PlayerManager;
import entity.PlayerEntity;
import manager.PlayerMercsManager;
import entity.PlayerMercsEntity;
import manager.BattleFieldManager;
import manager.ComputerMercsManager;
import manager.BossMercManager;
import manager.WeaponsManager;
import manager.PlayerWeaponsManager;
import entity.PlayerWeaponsEntity;
import entity.WeaponsEntity;
import java.util.Calendar;

import java.util.List;

import util.SpringBeanContextFactory;

public class maintestingrun {

	public static void main(String[] args) {

		MercManager mm = (MercManager) SpringBeanContextFactory
				.loadXmlBeanResources().getBean("mercManager");
		BattleFieldManager bfm = (BattleFieldManager) SpringBeanContextFactory
				.loadXmlBeanResources().getBean("battleFieldManager");
		ComputerMercsManager cmm = (ComputerMercsManager) SpringBeanContextFactory
				.loadXmlBeanResources().getBean("computerMercsManager");
		BossMercManager bmm = (BossMercManager) SpringBeanContextFactory
				.loadXmlBeanResources().getBean("bossMercManager");
		PlayerManager pm = (PlayerManager) SpringBeanContextFactory
				.loadXmlBeanResources().getBean("playerManager");
		PlayerMercsManager pmm = (PlayerMercsManager) SpringBeanContextFactory
				.loadXmlBeanResources().getBean("playerMercsManager");
		WeaponsManager wm = (WeaponsManager) SpringBeanContextFactory
				.loadXmlBeanResources().getBean("weaponsManager");
		
	/*try{
	    List<PlayerEntity> pList = pm.getAllPlayers();
	    List<MercEntity> mList = mm.getAllMercs();
	    PlayerEntity pe= pList.get(0);
	    	PlayerMercsEntity pme = new PlayerMercsEntity();
	    	double i = ((Math.random() * 10000) % mList.size()) + 1;
	    	MercEntity me = mList.get((int)i);
	    	pme.setMercId(me.getId());
	    	pme.setPlayerId(pe.getID());
	    	pme.setMLevel(1);
	    	pme.setAtk(me.getAtk());
	    	pme.setDef(me.getDef());
	    	pme.setHp(me.getHp());
	    	pme.setMercName(me.getMercName());
	    	pmm.addPlayer(pme);
	} catch(Throwable t){

		t.printStackTrace();
	}*/
	    
		for(Object p :  mm.getAllMercs()){
			MercEntity me = (MercEntity)p;
			
			System.out.println(me.getMercName());
			
		}
		
	/*	PlayerEntity pe = new PlayerEntity();
	 *  pe.setCash(0);
		pe.setExp(0);
		pe.setGold(0);
		pe.setLastCashTime(Calendar.getInstance().getTime());
		pe.setLevel(1);
		pe.setPlayerName("temp");
		pm.addPlayer(pe);
		BossMercEntity cme = new BossMercEntity();
		cme.setBattleFieldId(1);
		cme.setAtk((((int)(Math.random()*100000) % 100)+ 25));
		cme.setDef((((int)(Math.random()*100000) % 20)+10));
		cme.setExp((((int)(Math.random()*100000) % 300) + 100));
		cme.setGold((((int)(Math.random()*100000) % 250)+ 200));
		cme.setHoldAtk((((int)(Math.random()*100000) % 4)+ 3));
		cme.setHp((((int)(Math.random()*100000) % 300) + 50));
		bmm.addBossMerc(cme);*/
	/*	for (int i = 0; i <= 10; i++) {
			ComputerMercsEntity cme = new ComputerMercsEntity();
			cme.setBattleFieldId(1);
			cme.setAtk((((int)(Math.random()*100000) % 50)));
			cme.setDef((((int)(Math.random()*100000) % 10)));
			cme.setExp((((int)(Math.random()*100000) % 50) + 10));
			cme.setGold((((int)(Math.random()*100000) % 150)+ 100));
			cme.setHoldAtk((((int)(Math.random()*100000) % 4)+ 1));
			cme.setHp((((int)(Math.random()*100000) % 50) + 50));

			cmm.addComputerMerc(cme);
		}*/
	}

}
