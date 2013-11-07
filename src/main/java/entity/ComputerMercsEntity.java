package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="base", name="COMPUTERMERCS")
public class ComputerMercsEntity {

	@SequenceGenerator(schema= "base", name="serial",sequenceName="serial", allocationSize=1)
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="serial")
	private Integer id;
	@Column(name="BATTLEFIELD_ID")
	private Integer battleFieldId;
	@Column(name="HP")
	private Integer hp;
	@Column(name="ATK")
	private Integer atk;
	@Column(name="DEF")
	private Integer def;
	@Column(name="EXP")
	private Integer exp;
	@Column(name="GOLD")
	private Integer gold;
	@Column(name="HOLDATK")
	private Integer holdAtk;
	@Column(name="drop_ids")
	private String dropIds;
		
		
		public void setHoldAtk(int _holdatk){
			this.holdAtk = _holdatk;
		}
		
		public void setAtk(int _atk){
			this.atk = _atk;
		}
		
		public void setHp(int _hp){
			this.hp = _hp;
		}
		
		public void setDef(int _hp){
			this.def = _hp;
		}
		
		
		public int getHoldATK(){
			return holdAtk;
		}
		
		public void setID(int _id){
			this.id = _id;
		}
		public void setBattleFieldId(int _id){
			this.battleFieldId = _id;
		}
		public void setExp(int _id){
			this.exp = _id;
		}
		public void setGold(int _id){
			this.gold = _id;
		}
		public void setDropIDs(String _id){
			this.dropIds = _id;
		}

		public int getId(){
			return this.id;
			
		}
		
		public int getBattleFieldId(){
			return this.battleFieldId;
		}
		
		public int getExp(){
			return this.exp;
		}
		
		public int getGold(){
			return this.gold;
		}
		
		public String getDropIDs(){
			return this.dropIds;
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
	
}
