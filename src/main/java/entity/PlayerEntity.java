package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="base", name="PLAYER")
public class PlayerEntity {

	@SequenceGenerator(schema= "base", name="serial",sequenceName="serial", allocationSize=1)
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="serial")
	private Integer id;
	@Column(name="PLEVEL")
	private Integer plevel;
	@Column(name="EXP")
	private Integer exp;
	@Column(name="GOLD")
	private Integer gold;
	@Column(name="CASH")
	private Integer cash;
	@Column(name="PLAYERNAME")
	private String playerName;
	@Column(name="LASTCASHTIME")
	private Date lastCashTime;
	
	
	public void setPlayerName(String s){
		this.playerName = s;
	}
	
	public String getPlayerName(){
		return this.playerName;
	}

	public void setId(int _id){
		this.id = _id;
	}
	public void setLevel(int _id){
		this.plevel = _id;
	}
	public void setExp(int _id){
		this.exp = _id;
	}
	public void setGold(int _id){
		this.gold = _id;
	}
	public void setCash(int _id){
		this.cash = _id;
	}
	public void setLastCashTime(Date _date){
		this.lastCashTime = _date;
	}
	
	public int getID(){
		return this.id;
		
	}
	
	public int getLevel(){
		return this.plevel;
	}
	
	public int getExp(){
		return this.exp;
	}
	
	public int getGold(){
		return this.gold;
	}
	
	public int getCash(){
		return this.cash;
	}

	public Date getLastCashTime(){
		return this.lastCashTime;
	}
	
	
}
