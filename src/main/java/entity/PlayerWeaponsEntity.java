package entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="base", name="PLAYERWEAPONS")
public class PlayerWeaponsEntity {

	@SequenceGenerator(schema= "base", name="serial",sequenceName="serial", allocationSize=1)
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="serial")
	private Integer id;
	
	@Column(name="PLAYER_ID")
	private Integer playerId;
	
	@Column(name="WEAPONS_ID")
	private Integer weaponsId;
	
	@Column(name="PLAYERMERC_ID")
	private Integer playerMercId;
	
	
	
	public void setPlayerMercId(Integer playerMercId){
		this.playerMercId = playerMercId;
	}
	
	public Integer getPlayerMercId(){
		return this.playerMercId;
	}
	
	public void setId(Integer _id){
		this.id = _id;
	}
	
	public void setplayerId(Integer playerID){
		this.playerId = playerID;
	}
	
	public void setWeaponsId(Integer weaponsID){
		this.weaponsId = weaponsID;
	}
	
	public Integer getId(){
		return this.id;
	}
	
	public Integer  getplayerId(){
		return this.playerId;
	}
	
	public Integer  getWeaponsId(){
		return this.weaponsId;
	}
	
	
}
