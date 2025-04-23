package version1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {
	public String name;
	public float health;
	public int armor;
	public float melee_damage;
	public int gold = 0;
	public int battles_num = 0;
	public Weapon equ_weapon;
	public ArrayList<Weapon> inventory = new ArrayList<Weapon>();
	
	public Player(String name, float health, int armor, float melee_damage, Weapon weapon) {
		this.name = name;
		this.health = health;
		this.armor = armor;
		this.melee_damage = melee_damage;
		equ_weapon = weapon;
	}
	
	private Enemy HitEnemy(Enemy enemy) {
		enemy.health -= melee_damage + equ_weapon.attack;
		return enemy;
	}
	
	public void ToBattle() {
		battles_num++;
		int earned_gold = 0;
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		int enemies_num = rand.nextInt() % 4 + 1;
		ArrayList<Enemy> enemy_list = new ArrayList<Enemy>();
		
		if(battles_num % 5 != 0) {
			for(int i =0;i<enemies_num;i++) {
				enemy_list.add(new WeakEnemy("slime" + (i+1)));
			}
		}
		else {
			for(int i =0;i<4;i++) {
				enemy_list.add(new WeakEnemy("slime" + (i+1)));
			}
			enemy_list.add(new BossEnemy("slime boss"));
		}
		System.out.println("Встретились эти враги:");
		int i = 1;
		for(Enemy enemy : enemy_list) {
			System.out.println(i + ") " + enemy.name +"\t" + enemy.health);
			earned_gold += enemy.cost;
			i++;
		}
		
		while(health >= 0.0 && !enemy_list.isEmpty()) {
			System.out.println("Выбор:\n"
							 + "1)Нанести урон\n"
							 + "2)Ничего не делать");
			int choice = scan.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Кого атаковать:");
				i = 1;
				for(Enemy enemy : enemy_list) {
					System.out.println(i + ") " + enemy.name + "\t" + enemy.health);
					i++;
				}
				choice = scan.nextInt();
				i=1;
				for(Enemy enemy : enemy_list) {
					if (i==choice) {
						enemy_list.remove(enemy);
						enemy_list.add(choice-1, HitEnemy(enemy));
						if (enemy.health <= 0) {
							enemy_list.remove(enemy);
						}
						break;
					}
					i++;
				}
				break;
			case 2:
				
				break;
			}
		}
		if(health > 0) {
			gold += earned_gold; 
			System.out.println("Ты выиграл! Статистика:\n"
							 + "Заработано: " + earned_gold + "\n"
							 + "Осталось здоровья " + health + "\n"
							 + "Всего боёв: " + battles_num);
			
		}
	}
	
	public void ToShop() {
		
	}
	public void ChangeEquipment() {
		
	}
	public void RestoreHealth() {
		
	}
}
