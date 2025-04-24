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
	//public ArrayList<Weapon> inventory = new ArrayList<Weapon>();
	
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
		if (health <=0) {
			System.out.println("\nYour health below zero!\n");
			return;
		}
		
		battles_num++;
		int earned_gold = 0;
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		int enemies_num = rand.nextInt();
		if(enemies_num < 0) enemies_num *= (-1);
		enemies_num = enemies_num%4+1; 
		ArrayList<Enemy> enemy_list = new ArrayList<Enemy>();
		
		if(battles_num % 5 != 0) {				//adding weak enemies
			for(int i =0;i<enemies_num;i++) {
				enemy_list.add(new WeakEnemy("slime" + (i+1)));
			}
		}
		else {									//boss fight
			for(int i =0;i<4;i++) {
				enemy_list.add(new WeakEnemy("slime" + (i+1)));
			}
			enemy_list.add(new BossEnemy("slime boss"));
		}
		
		System.out.println("Встретились эти враги:"); //meeting enemies
		int i = 1;
		for(Enemy enemy : enemy_list) {
			System.out.println(i + ") " + enemy.name +"\t" + enemy.health);
			earned_gold += enemy.cost;
			i++;
		}
		
		while(health >= 0.0 && !enemy_list.isEmpty()) { //fight start
			System.out.println("\nВыбор:\n"
							 + "1)Нанести урон\n"
							 + "2)Ничего не делать");
			int choice = scan.nextInt();
			switch(choice) {
			case 1:											//who to hit
				System.out.println("Кого атаковать:");	
				i = 1;
				for(Enemy enemy : enemy_list) {
					System.out.println(i + ") " + enemy.name + "\t" + enemy.health);
					i++;
				}
				choice = scan.nextInt();					//choosing
				i=1;
				for(Enemy enemy : enemy_list) {				//hitting selected enemy
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
				for(Enemy enemy : enemy_list) {				//enemies attacking player
					health = enemy.Attack(health, armor);
				}
				System.out.println("Your health: "+health);
				break;
			case 2:											//do nothing
				
				break;
			}
		}
		if(health > 0) {					//if the battle ends with hp > 0
			gold += earned_gold; 
			System.out.println("Ты выиграл! Статистика:\n"
							 + "Заработано: " + earned_gold + "\n"
							 + "Осталось здоровья " + health + "\n"
							 + "Всего боёв: " + battles_num);
			
		}
	}
	
	public void ToShop(ArrayList<Weapon> weapon_list) {
		Scanner scan = new Scanner(System.in);
		int i = 1;
		while(true) {
			System.out.println("Твои деньги: "+ gold +"\nОружие на выбор:");
			for(Weapon weapon : weapon_list) {
				System.out.println(i+") " + weapon.name + "\tЦена: " + weapon.price);
				i++;
			}
			System.out.println("Выбери что купить(0 - выход)");
			int choice = scan.nextInt();
			switch(choice) {
			case 0:
				return;
			default:
				if(gold < weapon_list.get(choice-1).price) {
					System.out.println("Не хватает денег!");
					break;
				}
				equ_weapon = weapon_list.get(choice-1);
				weapon_list.remove(choice-1);
				gold -= equ_weapon.price;
			}
			i=1;
		}
	}
	public void ChangeEquipment() {
		
	}
	public void RestoreHealth() {
		
	}
}
