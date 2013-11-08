package util;

import manager.MercManager;
import entity.MercEntity;
import entity.ComputerMercsEntity;
import entity.BossMercEntity;
import manager.BattleFieldManager;
import manager.ComputerMercsManager;
import manager.BossMercManager;

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

		BossMercEntity cme = new BossMercEntity();
		cme.setBattleFieldId(1);
		cme.setAtk((((int)(Math.random()*100000) % 100)+ 25));
		cme.setDef((((int)(Math.random()*100000) % 20)+10));
		cme.setExp((((int)(Math.random()*100000) % 300) + 100));
		cme.setGold((((int)(Math.random()*100000) % 250)+ 200));
		cme.setHoldAtk((((int)(Math.random()*100000) % 4)+ 3));
		cme.setHp((((int)(Math.random()*100000) % 300) + 50));
		bmm.addBossMerc(cme);
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
