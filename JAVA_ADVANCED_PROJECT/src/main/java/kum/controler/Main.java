package kum.controler;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mysql.fabric.xmlrpc.base.Array;

import kum.entity.Cafe;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
//		new Aplication().run();
		
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
//		List<Cafe> cafes = em.createQuery("FROM Cafe", Cafe.class).getResultList();
//		for (Cafe cafe : cafes) {
//			System.out.println(cafe.getName());
//		}
		
//		List<Cafe> cafes = em.createQuery("FROM Cafe c WHERE c.id IN (:ids)", Cafe.class)
//				.setParameter("ids", Arrays.asList(8,9,10,11))
//				.getResultList();
//		for (Cafe cafe : cafes) {
//			em.remove(cafe);
//		}
//		List<Cafe> cafes = em.createQuery("FROM Cafe c WHERE c.fullDescription LIKE :fullDescription", Cafe.class)
//				.setParameter("fullDescription", "s%")
//				.getResultList();
//		for (Cafe cafe : cafes) {
//			cafe.setPhone("+5555555555");
//		}
//		Cafe cafe = em.find(Cafe.class, 1);
//		em.remove(cafe);
//		
		Long count = em.createQuery("SELECT count(c.id) FROM Cafe c", Long.class).getSingleResult();
		System.out.println(count);
		
		
		
		
		em.getTransaction().commit();
		em.close();
				
		factory.close();

	}

}
