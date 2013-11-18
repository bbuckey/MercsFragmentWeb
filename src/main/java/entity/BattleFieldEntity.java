package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

@Entity
@Table(schema="base", name="BATTLEFIELD")
public class BattleFieldEntity {

	@SequenceGenerator(schema= "base", name="serial",sequenceName="serial", allocationSize=1)
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="serial")
	private int id;
	
	@Column(name="LEVEL_NUMBER")
	private int levelNumber;
	

	
	public void setLevelNumber(int _merc){
		this.levelNumber = _merc;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getLevelNumber(){
		return this.levelNumber;
	}
	
	public int getId(){
		return this.id;
	}
	
	
}
