package kum.controler;

import java.time.LocalTime;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import kum.entity.Cafe;
import kum.entity.OpenClose;
import kum.entity.Type;

public class Aplication {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
	Scanner sc = new Scanner(System.in);

	public void run() {
		boolean isRun = true;
		while (isRun) {
			System.out.println("1. Select Entity of time;");
			System.out.println("2. Selekt entity;");
			System.out.println("3. Update Cafe;");
			System.out.println("4. Delet Cafe for id;");
			switch (sc.next()) {
			case "1":
				selectEntity(factory, sc);
				break;
			case "2":
				selectCafe(factory, sc);
				break;
			case "3":
				updaitCafe(factory, sc);
				break;
			case "4":
				removeCafe(factory, sc);
				break;

			default:
				break;
			}
		}
	}

	public void selectEntity(EntityManagerFactory factory, Scanner sc) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		OpenClose open = new OpenClose();
		System.out.println("Enter time to open houer and minutes");
		int oh = sc.nextInt();
		int om = sc.nextInt();
		open.setTime(LocalTime.of(oh, om));
		em.persist(open);
		em.getTransaction().commit();
		em.close();

	}

	public void selectCafe(EntityManagerFactory factory, Scanner sc) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		System.out.println("Enter address");
		String address = sc.next();
		System.out.println("Enter mail");
		String mail = sc.next();
		System.out.println("Enter full description");
		String full = sc.next();
		System.out.println("Enter name");
		String name = sc.next();
		System.out.println("Enter full phone");
		String phone = sc.next();
		System.out.println("Enter id of open time");
		int ot = sc.nextInt();
		System.out.println("Enter id of close time");
		int ct = sc.nextInt();
		OpenClose open = em.find(OpenClose.class, ot);
		OpenClose close = em.find(OpenClose.class, ct);
		Cafe cafe = new Cafe();
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
		cafe.setOpen(open);
		cafe.setClose(close);
		cafe.setAddress(address);
		cafe.setEmail(mail);
		cafe.setFullDescription(full);
		cafe.setName(name);
		cafe.setPhone(phone);
		em.persist(cafe);

		em.getTransaction().commit();
		em.close();
	}

	public void updaitCafe(EntityManagerFactory factory, Scanner sc) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		System.out.println("Select the id Cafe you want to change");
		int id = sc.nextInt();
		Cafe cafe = em.find(Cafe.class, id);
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
				String address = sc.next();
				cafe.setAddress(address);
				break;
			case "2":
				System.out.println("enter mail: ");
				String email = sc.next();
				cafe.setEmail(email);
				break;
			case "3":
				System.out.println("enter fullDescription: ");
				String fullDescription = sc.next();
				cafe.setFullDescription(fullDescription);
				break;
			case "4":
				System.out.println("enter name: ");
				String name = sc.next();
				cafe.setName(name);
				break;
			case "5":
				System.out.println("enter phone: ");
				String phone = sc.next();
				cafe.setPhone(phone);
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
				int ot = sc.nextInt();
				OpenClose open = em.find(OpenClose.class, ot);
				cafe.setOpen(open);
				break;
			case "8":
				System.out.println("Enter id of open time");
				int ct = sc.nextInt();
				OpenClose close = em.find(OpenClose.class, ct);
				cafe.setClose(close);
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
	
	
	public void removeCafe(EntityManagerFactory factory, Scanner sc){
   EntityManager em = factory.createEntityManager();
   em.getTransaction().begin();
   System.out.println("Enter id Cafe if you wont delet: ");
   int id = sc.nextInt();
    Cafe cafe = em.find(Cafe.class, id);
    em.remove(cafe);
   em.getTransaction().commit();
   em.close();
		
		
		
	}

}











