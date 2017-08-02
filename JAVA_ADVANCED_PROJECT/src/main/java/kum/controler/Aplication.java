package kum.controler;

import java.time.LocalTime;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import kum.entity.Cafe;
import kum.entity.OpenClose;

public class Aplication {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
	Scanner sc = new Scanner(System.in);
	
	public void run(){
		boolean isRun=true;
		while(isRun){
		System.out.println("1. Select Entity of time;");
		System.out.println("2. Add time;");
		System.out.println("3. Selekt entity ");
	switch (sc.next()) {
	case "1":
		selectEntity(factory, sc);
		break;
	case "2":
		addTimeToCafe(factory, sc);
		break;
	case "3":
		selectCafe(factory, sc);
		break;

	default:
		break;
	}
	}
	}
	
	public void selectEntity(EntityManagerFactory factory, Scanner sc){
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		OpenClose open = new OpenClose();
		System.out.println("Enter time to open houer and minutes");
		int oh= sc.nextInt();
		int om = sc.nextInt();
		open.setTime(LocalTime.of(oh, om));
		em.persist(open);
		em.getTransaction().commit();
		em.close();
		
	}
	
	
	public void addTimeToCafe(EntityManagerFactory factory, Scanner sc){
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		System.out.println("Enter id of time");
		int id = sc.nextInt();
		Cafe cafe = new Cafe();
		OpenClose open = em.find(OpenClose.class, id);
		cafe.setOpen(open);
		em.persist(cafe);
		
	
	em.getTransaction().commit();
	em.close();
	}
	
	public void selectCafe(EntityManagerFactory factory, Scanner sc){
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
	
	
	

}
