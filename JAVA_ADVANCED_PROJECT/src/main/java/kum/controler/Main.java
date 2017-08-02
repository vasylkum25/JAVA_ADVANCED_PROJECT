package kum.controler;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import kum.entity.Cafe;
import kum.entity.OpenClose;
import kum.entity.Type;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
//		EntityManager em = factory.createEntityManager();
//		em.getTransaction().begin();
////		OpenClose open = new OpenClose(LocalTime.of(10, 0));
////		em.persist(open);
////		em.detach(open);
////		open.setTime(LocalTime.of(23, 0));
////		em.merge(open);
//		OpenClose open = em.find(OpenClose.class, 1);
//		OpenClose close = em.find(OpenClose.class, 4);
////		openClose.setTime(LocalTime.of(10, 0));
////		em.remove(open);
//		Cafe cafe = new Cafe();
//		cafe.setAddress("Lviv, sq. Shevchenka 25");
//		cafe.setClose(close);
//		cafe.setEmail("Chocolad@gmail.com");
//		cafe.setFullDescription("Full desc");
//		cafe.setName("KUM_CAFE");
//		cafe.setOpen(open);
//		cafe.setPhone("+358956454");
//		cafe.setShortDescription("Short desc");
//		cafe.setType(Type.CAFE);
//		em.persist(cafe);
//		em.getTransaction().commit();
//		em.close();
		new Aplication().run();
		factory.close();

	}

}
