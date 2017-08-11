package kum.controler;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;

public class OtherFunction {

	public static void run(EntityManagerFactory factory, Scanner sc) {
		boolean isRun = true;
		while (isRun) {
			System.out.println("Enter 1 to select an operation above the table Cafe");
			System.out.println("Enter 2 to select an operation above the table Cuisine");
			System.out.println("Enter 3 to select an operation above the table Ingredient");
			System.out.println("Enter 4 to select an operation above the table Meal");
			System.out.println("Enter 5 to select an operation above the table Table");
			System.out.println("Enter 6 to select an operation above the table Order");
			System.out.println("Enter 0 to exit");
			switch (sc.next()) {
			case "1":
				
				break;
			case "2":
				
				break;
			case "3":
				
				break;
			case "4":
				
				break;
			case "5":
				
				break;
			case "6":
				
				break;
			case "7":
				
				break;
			case "0":
				isRun = false;
				break;
			default:
				isRun = false;
				break;
			}

		}
	}

	
	
	
}
