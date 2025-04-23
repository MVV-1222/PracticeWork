package version1;

import java.util.ArrayList;

public class Player {
	public String name;
	public float health;
	public int armor;
	public float melee_damage;
	public int gold = 0;
	public Weapon equ_weapon;
	public ArrayList<Weapon> inventory = new ArrayList<Weapon>();
	
	public Player(String name, float health, int armor, float melee_damage, Weapon weapon) {
		this.name = name;
		this.health = health;
		this.armor = armor;
		this.melee_damage = melee_damage;
		equ_weapon = weapon;
	}
	private float HitEnemy(Enemy enemy) {
		enemy.health -= melee_damage + equ_weapon.attack;
		return enemy.health;
	}
	public void ToBattle() {
		
	}
	public void ToShop() {
		
	}
	public void ChangeEquipment() {
		
	}
}
