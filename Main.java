package version1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int choice = 2;
		System.out.println("1)Начать игру\n"
						 + "2)Выйти\n");
		choice = scan.nextInt();
		if(choice == 2)
			return;
		float hp = 0, atk = 0 ;
		int def = 0;
		Weapon weapon = new Weapon("none", -1);
		System.out.println("Выбкри класс:\n"
						 + "1)Воин (100 hp 50 def 20 atk)\n"
						 + "2)Вор  (150 hp 20 def 15 atk)\n"
						 + "3)Маг  (120 hp 10 def 35 atk)\n");
		choice = scan.nextInt();
		switch(choice) {
		case 1:
			hp = 100;
			def = 50; 
			atk = 5; 
			weapon = new Weapon("sword1",15);
			break;
		case 2:			
			hp = 150;
			def = 20; 
			atk = 5; 
			weapon = new Weapon("sword1",10);
			break;
		case 3:
			hp = 120;
			def = 10; 
			atk = 5; 
			weapon = new Weapon("sword1",30);
			break;
		}
		System.out.println("Введите имя:");
		String name = scan.nextLine();
		Player player = new Player(name, hp, def, atk, weapon);
		while(choice!=0) {
			System.out.println("Меню:\n"
							 + "1)Пойти в бой\n"
							 + "2)Магзин\n"
							 + "3)Сменить снаряжение\n"
							 + "0)Выйти из игры(потерять прогресс)\n");
			choice = scan.nextInt();
			switch(choice) {
			case 1:
				player.ToBattle();
				break;
			case 2:
				player.ToShop();
				break;
			case 3:
				player.ChangeEquipment();
				break;
			}
		}
		
		
		return;
	}
}
