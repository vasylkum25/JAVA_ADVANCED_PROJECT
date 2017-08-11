package kum.controler;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import kum.entity.Cafe;

public class CafeSelectJoinAndAgregat {

	public static void run(EntityManagerFactory factory, Scanner sc) {
		boolean isRun = true;
		while (isRun) {
			System.out.println("Enter 1 to search Cafe");
			System.out.println("Enter 0 to exit");
			switch (sc.next()) {
			case "1":
				selectByName(factory, sc);
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
	
	
	public static void selectByName(EntityManagerFactory factory, Scanner sc){
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		List<Cafe> cafes =  em.createQuery("SELECT c FROM Cafe c JOIN FETCH c.close WHERE c.name LIKE :name", Cafe.class)
				.setParameter("name", "S%")
				.getResultList();
		for (Cafe cafe : cafes) {
			System.out.println(cafe.getName()+" close in: "+ cafe.getClose().getTime());
		}
		
		em.getTransaction().commit();
		em.close();	
	}
	
}
