package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

@Entity
@Table(schema="base", name="BATTLEFIELDDROPS")
public class BattleFieldDropsEntity {

	@SequenceGenerator(schema= "base", name="serial",sequenceName="serial", allocationSize=1)
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="serial")
	private Integer id;
	
	@Column(name="MERCS_ID")
	private Integer mercsId;
	
	@Column(name="WEAPONS_ID")
	private Integer weaponsId;
	
	@Column(name="BATTLEFIELD_ID")
	private Integer battleFieldId;
	

	public void setMercId(Integer _merc){
		this.mercsId = _merc;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public int getMercId(){
		return this.mercsId;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setWeaponsId(Integer id){
		this.weaponsId = id;
	}
	
	public int getWeaponsId(){
		return this.weaponsId;
	}
	
	
	public void setBattleFieldId(Integer id){
		this.battleFieldId = id;
	}
	
	public int getBattleFieldId(){
		return this.battleFieldId;
	}
	
}
