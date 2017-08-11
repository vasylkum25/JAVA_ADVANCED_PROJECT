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

public class InsertTable {

	public void run(EntityManagerFactory factory, Scanner sc) {
		boolean isRun = true;
		while (isRun) {
			System.out.println("Enter 1 to insert table Open_Close");
			System.out.println("Enter 2 to insert table Cafe");
			System.out.println("Enter 3 to insert table Cuisine");
			System.out.println("Enter 4 to insert table Ingredient");
			System.out.println("Enter 5 to insert table Meal");
			System.out.println("Enter 6 to insert table Table");
			System.out.println("Enter 7 to insert table Order");
			System.out.println("Enter 0 to exit");
			switch (sc.next()) {
			case "1":
				insertOpenClose(factory, sc);
				break;
			case "2":
				insertCafe(factory, sc);
				break;
			case "3":
				insertCuisine(factory, sc);
				break;
			case "4":
				insertIngredient(factory, sc);
				break;
			case "5":
				insertMeal(factory, sc);
				break;
			case "6":
				insertTable(factory, sc);
				break;
			case "7":
				insertOrder(factory, sc);
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

	public void insertOpenClose(EntityManagerFactory factory, Scanner sc) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		OpenClose open = new OpenClose();
		System.out.println("Enter time to open houer");
		int oh = sc.nextInt();
		System.out.println("Enter time to open minutes");
		int om = sc.nextInt();
		open.setTime(LocalTime.of(oh, om));
		em.persist(open);
		em.getTransaction().commit();
		em.close();
	}

	public void insertCafe(EntityManagerFactory factory, Scanner sc) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Cafe cafe = new Cafe();
		System.out.println("Enter address");
		cafe.setAddress(String.valueOf(sc.next()).replace("_", " "));
		System.out.println("Enter mail");
		cafe.setEmail(sc.next());
		System.out.println("Enter full description");
		cafe.setFullDescription(String.valueOf(sc.next()).replace("_", " "));
		System.out.println("Enter name");
		cafe.setName(sc.next());
		System.out.println("Enter phone number");
		cafe.setPhone(sc.next());
		System.out.println("Enter id of open time");
		cafe.setOpen(em.find(OpenClose.class, sc.nextInt()));
		System.out.println("Enter id of close time");
		cafe.setClose(em.find(OpenClose.class, sc.nextInt()));
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
		em.persist(cafe);
		em.getTransaction().commit();
		em.close();
	}

	public void insertCuisine(EntityManagerFactory factory, Scanner sc) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Cuisine cuisine = new Cuisine();
		System.out.println("Enter name of cuisine: ");
		cuisine.setName(sc.next());
		em.persist(cuisine);
		em.getTransaction().commit();
		em.close();
	}

	public void insertIngredient(EntityManagerFactory factory, Scanner sc) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Ingredient ingredient = new Ingredient();
		System.out.println("Enter name of ingredient: ");
		ingredient.setName(sc.next());
		em.persist(ingredient);
		em.getTransaction().commit();
		em.close();
	}

	public void insertMeal(EntityManagerFactory factory, Scanner sc) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Meal meal = new Meal();
		System.out.println("Enter title of meal: ");
		meal.setTitle(sc.next());
		System.out.println("Enter price: ");
		meal.setPrice(sc.nextBigDecimal());
		System.out.println("Enter discription: ");
		meal.setDescription((String.valueOf(sc.next())).replaceAll("-", " "));
		System.out.println("Enter id of cuisine: ");
		meal.setCuisine(em.find(Cuisine.class, sc.nextInt()));
		System.out.println("Enter id of cafe: ");
		meal.setCafe(em.find(Cafe.class, sc.nextInt()));
		em.persist(meal);
		em.getTransaction().commit();
		em.close();
	}

	public void insertOrder(EntityManagerFactory factory, Scanner sc) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Order order = new Order();
		System.out.println("enter table id: ");
		order.setTable(em.find(Table.class, sc.nextInt()));
		em.persist(order);
		em.getTransaction().commit();
		em.close();
	}

	public void insertTable(EntityManagerFactory factory, Scanner sc) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Table table = new Table();
		System.out.println("Enter count of people: ");
		table.setCountOfPeople(sc.nextInt());
		System.out.println("Enter id cafe: ");
		table.setCafe(em.find(Cafe.class, sc.nextInt()));
		System.out.println("Table is frea?(y/n)");
		String frea = sc.next();
		if (frea.equals("y")) {
			table.setFree(Boolean.valueOf(true));
		} else {
			table.setFree(Boolean.valueOf(false));
		}
		em.persist(table);
		em.getTransaction().commit();
		em.close();
	}
}
