package version1;

abstract public class Enemy {
	String name;
	float health;
	float melee_damage;
	int cost;
	
	Enemy(String name, float health, float melee_damage, int cost){
		this.name = name;
		this.health = health;
		this.melee_damage = melee_damage;
		this.cost = cost;
	}
	
	void Attack(Player player) {
		float attack = melee_damage/player.armor;
		player.health -= attack;
		System.out.println("-" + attack + " hp");
	}
}
