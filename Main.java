package version1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int choice = 2;
		
		System.out.println("1)Начать игру\n"	//start menu
						 + "2)Выйти\n");
		choice = scan.nextInt();
		
		if(choice == 2)					//handle users choice
			return;
		float hp = 0, atk = 0 ;
		int def = 0;
		Weapon weapon = new Weapon("none", -1, -1, 0);
		
		System.out.println("Выбкри класс:\n"				//choosing players class
						 + "1)Воин (100 hp 50 def 20 atk)\n"
						 + "2)Вор  (150 hp 20 def 15 atk)\n"
						 + "3)Маг  (80 hp 10 def 35 atk)\n");
		choice = scan.nextInt();
		
		switch(choice) {		//handle users choice
		case 1:
			hp = 100;
			def = 50; 
			atk = 5; 
			weapon = new Weapon("sword1",15, 1, 0);
			break;
		case 2:			
			hp = 150;
			def = 20; 
			atk = 5; 
			weapon = new Weapon("sword1",10, 1, 0);
			break;
		case 3:
			hp = 120;
			def = 10; 
			atk = 5; 
			weapon = new Weapon("wand1",30, 2, 0);
			break;
		}
		
		System.out.println("Введите имя:");		//user typing a name
		String name = scan.nextLine();
		
		Player player = new Player(name, hp, def, atk, weapon);//create Player object
		
		ArrayList<Weapon> swords = new ArrayList<Weapon>();//create weapons in shop
		ArrayList<Weapon> wands = new ArrayList<Weapon>();
		
		swords.add(new Weapon("sword2", 40, 1, 30));//swords
		swords.add(new Weapon("sword3", 70, 1, 60));
		swords.add(new Weapon("sword4", 90, 1, 90));

		wands.add(new Weapon("wand2", 50, 2, 30));//wands
		wands.add(new Weapon("wand3", 70, 2, 60));
		wands.add(new Weapon("wand4", 90, 2, 90));
		
		while(choice!=0) {				//main menu
			System.out.println("Меню:\n"
							 + "1)Пойти в бой\n"
							 + "2)Магзин\n"
							 + "3)Восстановить силы\n"
							 + "0)Выйти из игры(потерять прогресс)\n");
			choice = scan.nextInt();
			
			switch(choice) {		//handle users choice
			case 1:
				player.ToBattle();
				break;
			case 2:
				if(player.equ_weapon.access == 1)
					player.ToShop(swords);
				else if(player.equ_weapon.access == 2)
					player.ToShop(wands);
				break;
			case 3:
				player.RestoreHealth();
				break;
			}
		}
		scan.close();
		return;
	}
}
