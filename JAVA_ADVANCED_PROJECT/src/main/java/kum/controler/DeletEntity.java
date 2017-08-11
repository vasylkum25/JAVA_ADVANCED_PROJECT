package kum.controler;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import kum.entity.Cafe;
import kum.entity.Cuisine;
import kum.entity.Ingredient;
import kum.entity.Meal;
import kum.entity.OpenClose;
import kum.entity.Order;
import kum.entity.Table;

public class DeletEntity {
	public static void run(EntityManagerFactory factory, Scanner sc) {
		boolean isRun = true;
		while (isRun) {
			System.out.println("Enter 1 to delet Open_Close");
			System.out.println("Enter 2 to delet Cafe");
			System.out.println("Enter 3 to delet Cuisine");
			System.out.println("Enter 4 to delet Ingredient");
			System.out.println("Enter 5 to delet Meal");
			System.out.println("Enter 6 to delet Table");
			System.out.println("Enter 7 to delet Order");
			System.out.println("Enter 0 to exit");
			switch (sc.next()) {
			case "1":
				deletEntyty(factory, sc, OpenClose.class);
				break;
			case "2":
				deletEntyty(factory, sc, Cafe.class);
				break;
			case "3":
				deletEntyty(factory, sc, Cuisine.class);
				break;
			case "4":
				deletEntyty(factory, sc, Ingredient.class);
				break;
			case "5":
				deletEntyty(factory, sc, Meal.class);
				break;
			case "6":
				deletEntyty(factory, sc, Table.class);
				break;
			case "7":
				deletEntyty(factory, sc, Order.class);
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

	public static void deletEntyty(EntityManagerFactory factory, Scanner sc, Class<?> clas){
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		System.out.println("Enter id");
		em.remove(em.find(clas, sc.nextInt()));
				em.getTransaction().commit();
		em.close();
	}
	}

