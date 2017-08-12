package kum.controler;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Menu {
	
	
	public static void run(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
		Scanner sc = new Scanner(System.in);
		boolean isRun = true;
		while(isRun){
			System.out.println("Chues operation");
			System.out.println("Enter 1 to insert Entity");
			System.out.println("Enter 2 to update Entity");
			System.out.println("Enter 3 to delete Entity");
			System.out.println("Enter 4 to use other function");
			System.out.println("Enter 5 meal ingredient");
			switch (sc.next()) {
			case "1":
				new InsertTable().run(factory, sc);
				break;
			case "2":
				UpdateTable.run(factory, sc);
				break;
			case "3":
				DeletEntity.run(factory, sc);
				
				break;
			case "4":
				CafeSelectJoinAndAgregat.run(factory, sc);
				
				break;
			case "5":
				MealSelectJoinAndAgregat.run(factory, sc);	
				break;

			default:
				break;
			}
		}
	}
	
	
}
