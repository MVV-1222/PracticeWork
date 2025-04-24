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
	
	float Attack(float player_health, int player_armor) {
		float attack = melee_damage/player_armor;
		player_health -= attack;
		System.out.println("-" + attack + "players hp");
		return player_health;
	}
}
