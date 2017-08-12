package kum.controler;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import kum.entity.Ingredient;
import kum.entity.Meal;

public class MealSelectJoinAndAgregat {
	public static void run(EntityManagerFactory factory, Scanner sc) {
		boolean isRun = true;
		while (isRun) {
			System.out.println("Enter 1 to add ingredient in meal");
			System.out.println("Enter 2 to delet ingredient in meal");
			System.out.println("Enter 3 to update ingredient in meal");
			System.out.println("Enter 4 to print meal");
			System.out.println("Enter 5 to print meal");
			System.out.println("Enter 0 to exit");
			switch (sc.next()) {
			case "1":
				addIngredient(factory, sc);
				break;
			case "2":
				deletIngredient(factory, sc);
				break;
			case "3":
				updateIngredient(factory, sc);
				break;
			case "4":
				printMealIngredients(factory, sc);
				break;
			case "5":
				printMeal(factory, sc);
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
	
	public static void addIngredient(EntityManagerFactory factory, Scanner sc){
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		System.out.println("enter id of meal");
		int id =sc.nextInt();
		System.out.println("Enter ingredient if you whont to add");
		String ing = sc.next();
		Meal meal = em.createQuery("SELECT m FROM Meal m WHERE m.id=?1", Meal.class)
				.setParameter(1, id)
				.getSingleResult();
		meal.getIngredients().add(em.createQuery("SELECT i FROM Ingredient i WHERE i.name=?1", Ingredient.class)
				.setParameter(1, ing)
				.getSingleResult());
		em.getTransaction().commit();
		em.close();
	}


public static void deletIngredient(EntityManagerFactory factory, Scanner sc){
	EntityManager em = factory.createEntityManager();
	em.getTransaction().begin();
	System.out.println("enter id of meal");
	int id =sc.nextInt();
	System.out.println("Enter ingredient if you whont to delete");
	String ing = sc.next();
	Meal meal = em.createQuery("SELECT m FROM Meal m WHERE m.id=?1", Meal.class)
			.setParameter(1, id)
			.getSingleResult();
	meal.getIngredients().remove(em.createQuery("SELECT i FROM Ingredient i WHERE i.name=?1", Ingredient.class)
			.setParameter(1, ing)
			.getSingleResult());
	em.getTransaction().commit();
	em.close();
}

public static void updateIngredient(EntityManagerFactory factory, Scanner sc){
	EntityManager em = factory.createEntityManager();
	em.getTransaction().begin();
	System.out.println("enter id of meal");
	int id =sc.nextInt();
	System.out.println("Enter ingredient if you whont to update");
	String ing = sc.next();
	System.out.println("Enter id ingredient if you whont to update");
	int ingid = sc.nextInt();
	Meal meal = em.createQuery("SELECT m FROM Meal m WHERE m.id=?1", Meal.class)
			.setParameter(1, id)
			.getSingleResult();
	meal.getIngredients().set(ingid,(em.createQuery("SELECT i FROM Ingredient i WHERE i.name=?1", Ingredient.class)
			.setParameter(1, ing)
			.getSingleResult()));
	em.getTransaction().commit();
	em.close();
}

public static void printMealIngredients(EntityManagerFactory factory, Scanner sc){
	EntityManager em = factory.createEntityManager();
	em.getTransaction().begin();
	System.out.println("enter id of meal");
	int id =sc.nextInt();
	Meal meal = em.createQuery("SELECT m FROM Meal m WHERE m.id=?1", Meal.class)
			.setParameter(1, id)
			.getSingleResult();
	System.out.println(meal.getTitle() + "have contein ingredients: ");
	for (Ingredient ingredient :  meal.getIngredients()) {
		System.out.print(ingredient.getName()+", ");
	}
	em.getTransaction().commit();
	em.close();
	System.out.println("");
}
public static void printMeal(EntityManagerFactory factory, Scanner sc){
	EntityManager em = factory.createEntityManager();
	em.getTransaction().begin();
	System.out.println("enter id of meal whot you whont to print");
	int id =sc.nextInt();
	Meal meal = em.createQuery("SELECT m FROM Meal m WHERE m.id=?1", Meal.class)
			.setParameter(1, id)
			.getSingleResult();
	System.out.println(meal);
	em.getTransaction().commit();
	em.close();
}
}
