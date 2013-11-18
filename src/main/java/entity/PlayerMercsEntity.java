package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="base", name="PLAYERMERCS")
public class PlayerMercsEntity {
	
	@SequenceGenerator(schema= "base", name="serial",sequenceName="serial", allocationSize=1)
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="serial")
	private Integer id;
	@Column(name="PLAYER_ID")
	private Integer playerId;
	@Column(name="MERCS_ID")
	private Integer mercId;
	@Column(name="MERCNAME")
	private String mercName;
	@Column(name="HP")
	private int hp;
	@Column(name="ATK")
	private int atk;
	@Column(name="DEF")
	private int def;
	@Column(name="MLEVEL")
	private int level;
	

	
	public void setId(Integer _id){
		this.id = _id;
	}
	public void setPlayerId(Integer _id){
		this.playerId = _id;
	}
	public void setMercId(Integer _id){
		this.mercId = _id;
	}

	public void setAtk(Integer _atk){
		this.atk = _atk;
	}
	
	public void setLevel(Integer _hp){
		this.level = _hp;
	}
	
	public void setHp(Integer _hp){
		this.hp = _hp;
	}
	
	public void setDef(Integer _hp){
		this.def = _hp;
	}
	
	public void setMercName(String _hp){
		this.mercName = _hp;
	}
	
	public Integer getAtk(){
		return this.atk;
	}
	
	public Integer getHp(){
		return this.hp;
	}
	
	public Integer getId(){
		return this.id ;
	}
	
	public Integer getDef(){
		return this.def;
	}
	
	public String getMercName(){
		return this.mercName;
	}
	
	public Integer getLevel(){
		return this.level;
	}
	
	public Integer getPlayerId(){
		return this.playerId;
	}
	public Integer getMercId(){
		return this.mercId;
	}

}
