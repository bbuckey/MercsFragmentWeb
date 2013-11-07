package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

@Entity
@Table(schema="base", name="MERCS")
public class MercEntity {

	@SequenceGenerator(schema= "base", name="serial",sequenceName="serial", allocationSize=1)
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="serial")
	private Integer id;
	
	@Column(name="MERCNAME")
	private String mercName;
	
	@Column(name="HP")
	private Integer hp;
	
	@Column(name="ATK")
	private Integer atk;
	
	@Column(name="DEF")
	private Integer def;
	
	public void setAtk(Integer _atk){
		this.atk = _atk;
	}
	
	public void setHp(Integer _hp){
		this.hp = _hp;
	}
	
	public void setDef(Integer _hp){
		this.def = _hp;
	}
	
	public void setId(Integer _hp){
		this.id = _hp;
	}
	
	public void setMercName(String _hp){
		this.mercName = _hp;
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
	
	
	public String getMercName(){
		return this.mercName;
	}
	
}
