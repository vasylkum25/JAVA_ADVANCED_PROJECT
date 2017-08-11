package kum.controler;

import java.time.LocalTime;
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
import kum.entity.Type;

public class UpdateTable {

	public static void run(EntityManagerFactory factory, Scanner sc) {
		boolean isRun = true;
		while (isRun) {
			System.out.println("Enter 1 to update table Cafe");
			System.out.println("Enter 2 to update table Cuisine");
			System.out.println("Enter 3 to update table Ingredient");
			System.out.println("Enter 4 to update table Meal");
			System.out.println("Enter 5 to update table Table");
			System.out.println("Enter 6 to update table Order");
			System.out.println("Enter 0 to exit");
			switch (sc.next()) {
			case "1":
				updateCafe(factory, sc);
				break;
			case "2":
				updateCuisine(factory, sc);
				break;
			case "3":
				updateIngredient(factory, sc);
				break;
			case "4":
				updateMeal(factory, sc);
				break;
			case "5":
				updateTable(factory, sc);
				break;
			case "6":
				updateOrder(factory, sc);
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

	public static void updateCafe(EntityManagerFactory factory, Scanner sc) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		System.out.println("Select the id Cafe if you want to change");
		Cafe cafe = em.find(Cafe.class, sc.nextInt());
		boolean isRun = true;
		while (isRun) {
			System.out.println("Select the field you want to change");
			System.out.println("1. Address;");
			System.out.println("2. Email;");
			System.out.println("3. Full Description;");
			System.out.println("4. Name;");
			System.out.println("5. Phone;");
			System.out.println("6. Type;");
			System.out.println("7. Open hour;");
			System.out.println("8. Clouse hour;");
			System.out.println("0. to exit");
			switch (sc.next()) {
			case "1":
				System.out.println("enter address: ");
				cafe.setAddress(sc.next());
				break;
			case "2":
				System.out.println("enter mail: ");
				cafe.setEmail(sc.next());
				break;
			case "3":
				System.out.println("enter fullDescription: ");
				cafe.setFullDescription((sc.next()).replaceAll("_", " "));
				break;
			case "4":
				System.out.println("enter name: ");
				cafe.setName(sc.next());
				break;
			case "5":
				System.out.println("enter phone: ");
				cafe.setPhone(sc.next());
				break;
			case "6":
				System.out.println("Choos type of cafe: ");
				System.out.println("1. PUB;");
				System.out.println("2. SUSHY;");
				System.out.println("3. BAR;");
				System.out.println("4. CAFE;");
				System.out.println("5. RESTAURANT;");
				switch (sc.next()) {
				case "1":
					cafe.setType(Type.PUB);
					break;
				case "2":
					cafe.setType(Type.SUSHY);
					break;
				case "3":
					cafe.setType(Type.BAR);
					break;
				case "4":
					cafe.setType(Type.CAFE);
					break;
				case "5":
					cafe.setType(Type.RESTAURANT);
					break;
				default:
					break;
				}
				break;
			case "7":
				System.out.println("Enter id of open time");
				cafe.setOpen(em.find(OpenClose.class, sc.nextInt()));
				break;
			case "8":
				System.out.println("Enter id of open time");
				cafe.setClose(em.find(OpenClose.class, sc.nextInt()));
				break;
			case "0":
				isRun = false;
				break;

			default:
				break;
			}
		}
		em.persist(cafe);
		em.getTransaction().commit();
		em.close();

	}

	public static void updateOpenClose(EntityManagerFactory factory, Scanner sc) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		System.out.println("Enter id of time whot you wont to update: ");
		OpenClose open = em.find(OpenClose.class, sc.nextInt());
		System.out.println("Enter new time houe: r");
		int oh = sc.nextInt();
		System.out.println("Enter new time minutes: ");
		int om = sc.nextInt();
		open.setTime(LocalTime.of(oh, om));
		em.persist(open);
		em.getTransaction().commit();
		em.close();
	}

	public static void updateCuisine(EntityManagerFactory factory, Scanner sc) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		System.out.println("Enter id");
		Cuisine cuisine = em.find(Cuisine.class, sc.nextInt());
		System.out.println("Enter name of cuisine: ");
		cuisine.setName(sc.next());
		em.persist(cuisine);
		em.getTransaction().commit();
		em.close();
	}

	public static void updateIngredient(EntityManagerFactory factory, Scanner sc) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		System.out.println("Enter id: ");
		Ingredient ingredient = em.find(Ingredient.class, sc.nextInt());
		System.out.println("Enter name of ingredient: ");
		ingredient.setName(sc.next());
		em.persist(ingredient);
		em.getTransaction().commit();
		em.close();
	}

	public static void updateMeal(EntityManagerFactory factory, Scanner sc) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		System.out.println("Enter id: ");
		Meal meal = em.find(Meal.class, sc.nextInt());
		boolean isRun = true;
		while (isRun) {
			System.out.println("Enter whot you wont to update:");
			System.out.println("1. Title of meal: ");
			System.out.println("2. Price: ");
			System.out.println("3. Discription: ");
			System.out.println("4. Cuisine: ");
			System.out.println("5. Cafe: ");
			System.out.println("0. Exit ");
			switch (sc.next()) {
			case "1":
				System.out.println("Enter title: ");
				meal.setTitle(sc.next());
				break;
			case "2":
				System.out.println("Enter prise: ");
				meal.setPrice(sc.nextBigDecimal());
				break;
			case "3":
				System.out.println("Enter discription: ");
				meal.setDescription((sc.next()).replaceAll("_", " "));
				break;
			case "4":
				System.out.println("Enter id cuisine: ");
				meal.setCuisine(em.find(Cuisine.class, sc.nextInt()));
				break;
			case "5":
				System.out.println("Enter cafe: ");
				meal.setCafe(em.find(Cafe.class, sc.nextInt()));
				break;
			case "0":
				isRun = false;
				break;
			default:
				isRun = false;
				break;
			}
		}
		em.persist(meal);
		em.getTransaction().commit();
		em.close();
	}

	public static void updateOrder(EntityManagerFactory factory, Scanner sc) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		System.out.println("enter order id: ");
		Order order = em.find(Order.class, sc.nextInt());
		System.out.println("enter table id: ");
		order.setTable(em.find(Table.class, sc.nextInt()));
		em.persist(order);
		em.getTransaction().commit();
		em.close();
	}

	public static void updateTable(EntityManagerFactory factory, Scanner sc) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		System.out.println("Enter id");
		Table table = em.find(Table.class, sc.nextInt());
		boolean isRun = true;
		while (isRun) {
			System.out.println("Enter whot you wont to update:");
			System.out.println("1. Count of people: ");
			System.out.println("2. Cafe: ");
			System.out.println("3. Table is frea?(y/n) ");
			switch (sc.next()) {
			case "1":
				System.out.println("Enter count of people: ");
				table.setCountOfPeople(sc.nextInt());
				break;
			case "2":
				System.out.println("Enter id cafe: ");
				table.setCafe(em.find(Cafe.class, sc.nextInt()));
				break;
			case "3":
				System.out.println("Table is frea?(y/n)");
				String frea = sc.next();
				if (frea.equals("y")) {
					table.setFree(Boolean.valueOf(true));
				} else {
					table.setFree(Boolean.valueOf(false));
				}
				break;

			default:
				isRun=false;
				break;
			}
		}
		em.persist(table);
		em.getTransaction().commit();
		em.close();
	}
}
