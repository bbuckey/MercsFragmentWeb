package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
/*import entity.BattleFieldEntity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;;
*/
@Entity
@Table(schema="base", name="BOSSMERCS")
public class BossMercEntity {
	
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
		
		
		public void setHoldAtk(Integer _holdatk){
			this.holdAtk = _holdatk;
		}
		
		public void setAtk(Integer _atk){
			this.atk = _atk;
		}
		
		public void setHp(Integer _hp){
			this.hp = _hp;
		}
		
		public void setDef(Integer _hp){
			this.def = _hp;
		}
		
		
		public int getHoldATK(){
			return holdAtk;
		}
		
		public void setID(Integer _id){
			this.id = _id;
		}
		public void setBattleFieldId(Integer _id){
			this.battleFieldId = _id;
		}
		public void setExp(Integer _id){
			this.exp = _id;
		}
		public void setGold(Integer _id){
			this.gold = _id;
		}
		public void setDropIDs(String _id){
			this.dropIds = _id;
		}

		public int getId(){
			return this.id;
			
		}
		
		
		
		public Integer getBattleFieldId(){
			return this.battleFieldId;
		}
		
		public Integer getExp(){
			return this.exp;
		}
		
		public Integer getGold(){
			return this.gold;
		}
		
		public String getDropIDs(){
			return this.dropIds;
		}

		public Integer getAtk(){
			return this.atk;
		}
		
		public Integer getHp(){
			return this.hp;
		}
		
		
		public Integer getDef(){
			return this.def;
		}
	
}
