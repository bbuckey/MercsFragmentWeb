package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="base", name="WEAPONS")
public class WeaponsEntity {
	
	@SequenceGenerator(schema= "base", name="serial",sequenceName="serial", allocationSize=1)
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="serial")
	private int id;
	
	@Column(name="WEAPONNAME")
	private String weaponsName;
	
	@Column(name="HP")
	private int hp;
	
	@Column(name="ATK")
	private int atk;
	
	@Column(name="DEF")
	private int def;
	
	
	
	public void setAtk(int _atk){
		this.atk = _atk;
	}
	
	public void setHp(int _hp){
		this.hp = _hp;
	}
	
	public void setDef(int _hp){
		this.def = _hp;
	}
	
	public void setId(int _hp){
		this.id = _hp;
	}
	
	public void setWeaponsName(String _hp){
		this.weaponsName = _hp;
	}
	
	public int getAtk(){
		return this.atk;
	}
	
	public int getHp(){
		return this.hp;
	}
	
	
	public int getDef(){
		return this.def;
	}

	public int getId(){
		return this.id ;
	}
	
	
	public String getWeaponsName(){
		return this.weaponsName;
	}
}
